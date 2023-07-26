package myJdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

public class JdbcDemo {
	public static void main(String[] args) throws Exception {
		commit();
		System.out.println("=======================================================");
		insert();
		System.out.println("=======================================================");
		read();
		System.out.println("=======================================================");
		insertUsingPsg();
		System.out.println("=======================================================");
		read();
		System.out.println("=======================================================");
		delete();
		System.out.println("=======================================================");
		read();
		System.out.println("=======================================================");
		update();
		System.out.println("=======================================================");
		read();
		System.out.println("=======================================================");
		sp();
		System.out.println("=======================================================");
		sp2();
		System.out.println("=======================================================");
		sp3();
		System.out.println("=======================================================");
		read();
		System.out.println("=======================================================");
		commit();
		System.out.println("=======================================================");
		batchCommit();
		System.out.println("=======================================================");

	}

	public static void read() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";
		String query = "select * from employee;";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.print("ID = " + rs.getInt(1) + "  ");
			System.out.print("Ename = " + rs.getString(2) + "  ");
			System.out.print("Salary = " + rs.getInt(3) + "  ");
			System.out.println();
		}
		con.close();

	}

	public static void insert() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";
		int nu = 3;
		String name = "Dhanush";
		int sal = 1000;
		String query = "insert into employee values(" + nu + ",'" + name + "'," + sal + ");";
//		String query="insert into employee values(3,'Dhanush',1000)";
		Connection con = DriverManager.getConnection(url, user, pass);

		Statement st = con.createStatement();
	    
		int row = st.executeUpdate(query);
		System.out.println("No.Of.Rows affected = " + row);
		con.close();
	}

	public static void insertUsingPsg() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";
		int nu = 4;
		String name = "Varun";
		int sal = 5000;

		String query = "insert into employee values(?,?,?)";
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, nu);
		ps.setString(2, name);
		ps.setInt(3, sal);
		int rows = ps.executeUpdate();
		System.out.println("No.Of.Rows affected = " + rows);
		con.close();
	}

	public static void delete() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";

		String query = "delete from employee where emp_id = 2";
		Connection con = DriverManager.getConnection(url, user, pass);

		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("No.Of.Rows affected = " + row);
		con.close();
	}

	public static void update() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";

		String query = "update employee set salary = 50000000 where emp_id = 1";
		Connection con = DriverManager.getConnection(url, user, pass);

		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("No.Of.Rows affected = " + row);
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
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pass = "root";

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
		String url = "jdbc:mysql://localhost:3306/jdbc1";
		String user = "root";
		String pass = "root";
        String b="Bari";
		Connection con = DriverManager.getConnection(url, user, pass);
		CallableStatement query = con.prepareCall("{call GetEmpName(?)}");
		// don't need prepare statement for placeholder because callable statement includes it
		query.setString(1, b);
		ResultSet row = query.executeQuery();
		
		while (row.next()) {
			System.out.print("ID = " + row.getInt(1) + "  ");
			System.out.print("Ename = " + row.getString(2) + "  ");
			System.out.print("Salary = " + row.getInt(3) + "  ");
			System.out.println();
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
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String user = "root";
	String pass = "root";
    int id=2;
	Connection con = DriverManager.getConnection(url, user, pass);
	CallableStatement query = con.prepareCall("{call GetNameById(?,?)}");
	// don't need prepare statement for placeholder because callable statement includes it
	query.setInt(1, id);
	query.registerOutParameter(2, Types.VARCHAR);
	// 2 represents  the place holder position and types.Varchar is the out type datatype from sql
	query.executeUpdate();
	// use executeUpdate because in query we are making changes like getting out from it();
	System.out.println(query.getString(2));
	// this is the return type from the database it comes out from the second position placeholder
	
	con.close();
}
// commit auto commit
public static void commit() throws Exception {
	String url = "jdbc:mysql://localhost:3306/jdbc2";
	String user = "root";
	String pass = "root";
    String query1="update employee set salary = 400000000 where emp_id=1";
    String query2="update employee set salary = 200000 where emp_id=2";
    String queryre ="select * from employee";
    
	Connection con = DriverManager.getConnection(url, user, pass);
	con.setAutoCommit(false);
	/* the default process is auto commit we are disabling it because when a query fails and 
	 * another query succeed we don't need to save that both query in the database
	 * we can use if statement to handle the commit procedure by giving the conditions
	*/
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
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String user = "root";
	String pass = "root";
    String query1="update employee set salary = 100 where emp_id=1";
    String query2="update employee set salary = 200 where emp_id=2";
    String query3 ="update employee set salary = 50000 where emp_id=1";
    String query4 ="update employee set salary = 6000 where emp_id=2";
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
		
	}
	con.close();
}
}
    