package PSQL_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;
import org.postgresql.jdbc.PgStatement;

public class JDBC {
    public static void read() throws Exception {
    	System.out.println("Read the DataBase");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";
        String query = "select * from employee;";
        PgConnection con = (PgConnection) DriverManager.getConnection(url, user, pass);
        PgStatement st = (PgStatement) con.createStatement();
        PgResultSet rs = (PgResultSet) st.executeQuery(query);
        while (rs.next()) {
            System.out.print("ID = " + rs.getInt(1) + "  ");
            System.out.print("Ename = " + rs.getString(2) + "  ");
            System.out.print("Salary = " + rs.getInt(3) + "  ");
            System.out.println();
        }
        con.close();

 

    }

 

    public static void insert() throws Exception {
    	System.out.println("Insert the data");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";
        int ID = 6;
        String Ename ="Sakthi";
        int Salary = 8000;
        String query = "insert into employee values(" + ID + ",'" + Ename + "'," + Salary + ");";
        PgConnection con = (PgConnection) DriverManager.getConnection(url, user, pass);

 

        PgStatement st = (PgStatement) con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("No.Of.Rows affected = " + row);
        read();
        con.close();
    }

 

    public static void insertUsingPsg() throws Exception {
    	System.out.println("Inserting using placeholder");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";
        int nu = 7;
        String name = "Ajith";
        int sal = 9000;

        String query = "insert into employee values(?,?,?)";
        PgConnection con = (PgConnection) DriverManager.getConnection(url, user, pass);
 
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, nu);
        ps.setString(2, name);
        ps.setInt(3, sal);
        int rows = ps.executeUpdate();
        System.out.println("No.Of.Rows affected = " + rows);
        read();
        con.close();
    }

 

    public static void delete() throws Exception {
    	System.out.println("Delete using emp_id");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";

        String query = "delete from employee where emp_id = 2";
        Connection con = DriverManager.getConnection(url, user, pass);

        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("No.Of.Rows affected = " + row);
        read();
        con.close();
    }

 

    public static void update() throws Exception {
    	System.out.println("update");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";

        String query = "update employee set salary = 50000000 where emp_id = 7";
        Connection con = DriverManager.getConnection(url, user, pass); 

        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("No.Of.Rows affected = " + row);
        read();
        con.close();
    }

 

    /* callable statement
     * delimiter $$ create procedure GetEmp() 
     * begin 
     * select * 
     * from employee; 
     * end$$
     * delimiter ;
     */
    public static void sp() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";

        Connection con = DriverManager.getConnection(url, user, pass);
        CallableStatement query = con.prepareCall("{call GetEmp()}");
        ResultSet row = query.executeQuery();
        System.out.println("No.Of.Rows affected = " + row);
        while (row.next()) {
            System.out.print("ID = " + row.getInt(1) + "  ");
            System.out.print("Ename = " + row.getString(2) + "  ");
            System.out.print("Salary = " + row.getInt(3) + "  ");
            System.out.println();
        }
        con.close();
    }

    /* callable statement [stored procedure]
     * delimiter $$ create procedure GetEmp(In id int) 
     * begin 
     * select * 
     * from employee
     * where emp_id=id; 
     * end$$
     * delimiter ;
     */
    public static void sp2() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgres";
        int b=2;
        Connection con = DriverManager.getConnection(url, user, pass);
        CallableStatement query = con.prepareCall("{call GetEmpId(?)}");
        // don't need prepare statement for placeholder because callable statement includes it
        query.setInt(1, b);
        ResultSet row = query.executeQuery();
        System.out.println("No.Of.Rows affected = " + row);
//        row.next();
//        System.out.print("Ename = " + row.getString(2) + "  ");
//        while (row.next()) {
//            System.out.print("ID = " + row.getInt(1) + "  ");
//            System.out.print("Ename = " + row.getString(2) + "  ");
//            System.out.print("Salary = " + row.getInt(3) + "  ");
//            System.out.println();
//        }
        if (row.next()) {
            System.out.print("Ename = " + row.getString(2) + "  ");
        } else {
            System.out.println("No employee found with emp_id = " + b);
        }
        
        con.close();
    }
/* callable statement [stored procedure and out]
* delimiter $$ 
* create procedure GetNameById(In id int, out empname varchar(50)) 
* begin 
* select * 
* from employee
* where emp_id=id into empname;  
* end$$
* delimiter ;
*/
public static void sp3() throws Exception {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "postgres";
    int id=3;
    Connection con = DriverManager.getConnection(url, user, pass);
    CallableStatement query = con.prepareCall("{call GetNameById(?,?)}");
    query.setInt(1, id);
    query.registerOutParameter(2, Types.VARCHAR);
    query.executeUpdate();
    System.out.print("Ename : "+query.getString(2));
    con.close();
}
public static void commit() throws Exception {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "postgres";
    String query1="update employee set salary=400000000 where emp_id=1";
    String query2="update employee set salary=200000 where emp_id=2";
    String queryre ="select * from employee";

    Connection con = DriverManager.getConnection(url, user, pass);
    con.setAutoCommit(false);
    Statement st = con.createStatement();
    int row1 = st.executeUpdate(query1);
    System.out.println("No.Of.Rows affected = "+ row1);
    System.out.println("------------------------------------");
    int row2 = st.executeUpdate(query2);
    System.out.println("No.Of.Rows affected = "+ row2);
    if(row1>0 && row2>0) {
        con.commit();
    }
    ResultSet rs = st.executeQuery(queryre);
    while(rs.next()) {
        System.out.print("ID = " + rs.getInt(1) + "  ");
        System.out.print("Ename = " + rs.getString(2) + "  ");
        System.out.print("Salary = " + rs.getInt(3) + "  ");
        System.out.println();
    }
    con.close();
}

 

// Batch processing [combining more query]
public static void batchCommit() throws Exception {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "postgres";
    String query1="update employee set salary=100 where emp_id=1";
    String query2="update employee set salary=200 where emp_id=2";
    String query3 ="update employee set salary=50000 where emp_id=1";
    String query4 ="update employee set salary=6000 where emp_id=2";
    String queryre ="select * from employee";

    Connection con = DriverManager.getConnection(url, user, pass);

    con.setAutoCommit(false);
    /* the default process is auto commit we are disabling it because when a query fails and 
     * another query succeed we don't need to save that both query in the database
     * we can use if statement to handle the commit procedure by giving the conditions
    */
    Statement st = con.createStatement();

    st.addBatch(query1);
    st.addBatch(query2);
    st.addBatch(query3);
    st.addBatch(query4);
    int arr[]=st.executeBatch();
    // the batch returns in int arr so we are assigning array then to print we use for each 
    for (int ra : arr) {
        System.out.println("No.Of.Rows affected = "+ ra);
        if(ra>0) {
            continue;
        }
        else {
            con.rollback();
        }
    }
    ResultSet rs = st.executeQuery(queryre);
    while(rs.next()) {
        System.out.print("ID = " + rs.getInt(1) + "  ");
        System.out.print("Ename = " + rs.getString(2) + "  ");
        System.out.print("Salary = " + rs.getInt(3) + "  ");
        System.out.println();
    }
    con.close();
}
public static void main(String[] args) throws Exception {
//  System.out.println("=======================================================");
//  read();
//  System.out.println("=======================================================");
//	insert();
//	insertUsingPsg();
//	delete();
//	update();
//	sp();
//	sp2();
//	sp3();
//	commit();
	batchCommit();
}
}