package Practise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo{
	public static void main(String[] args) throws Exception {
		//insertRecord();
		insertRecordpsd();
		//readRecord();
		//delete();
		//update();
		//Spusingph();
	}
	public static void readRecord() throws Exception  {
	String url="jdbc:mysql://localhost:3306/JdbcDemo";
	String username="root";
	String password="root";
	String query="select * from employee";
	Connection con=DriverManager.getConnection(url, username, password);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
while (rs.next()) {
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
System.out.println(rs.getInt(3));
}
con.close();
	}
	public static void insertRecord() throws Exception  {
		String url="jdbc:mysql://localhost:3306/JdbcDemo";
		String username="root";
		String password="root";
		int id =9;
		String name="sharmi";
	int salary=250000;
		String query="insert into employee values (" + id + ",'" + name + "'," + salary+");";
		Connection con=DriverManager.getConnection(url, username, password);
	Statement st=con.createStatement();
	int row =st.executeUpdate(query);
	System.out.println(row);
	       
	con.close();
		}public static void insertRecordpsd() throws Exception  {
			String url="jdbc:mysql://localhost:3306/JdbcDemo";
			String username="root";
			String password="root";
			int id =5;
			String name="Dickson";
		int salary=2600000;
			String query="insert into employee values (?,?,?);";
			Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,id);
	pst.setString(2,name);
	pst.setInt(3,salary);
	int rows=pst.executeUpdate(); 	       
	System.out.println(rows);	
	con.close();
			}
		public static void delete()throws Exception{
			String url="jdbc:mysql://localhost:3306/JdbcDemo";
			String username="root";
			String password="root";
			int id =3;
			Connection con=DriverManager.getConnection(url, username, password);
			Statement st=con.createStatement();
			String query="delete from employee where emp_id="+ id ;
			int rows=st.executeUpdate(query);
			System.out.println(rows);
		}
public static void  update() throws Exception{
	String url="jdbc:mysql://localhost:3306/JdbcDemo";
	String username="root";
	String password="root";
Connection con=DriverManager.getConnection(url, username, password);
Statement st=con.createStatement();
String query="update employee set salary=150000 where emp_id=1";
int rows=st.executeUpdate(query);
System.out.println(rows);
}
public static void Sp()throws Exception{
	String url="jdbc:mysql://localhost:3306/JdbcDemo1";
	String username="root";
	String password="root";
	Connection con=DriverManager.getConnection(url, username, password);
	CallableStatement cst=con.prepareCall("{call GetEmp()}");
	ResultSet rs=cst.executeQuery();
	while (rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));

		
	}
	con.close();

	
}

public static void Spusingph()throws Exception{
	String url="jdbc:mysql://localhost:3306/JdbcDemo1";
	String username="root";
	String password="root";
	int id=3;
	Connection con=DriverManager.getConnection(url, username, password);
	CallableStatement st=con.prepareCall("{call GetEmpById(?)}");
	st.setInt(1,id);
	ResultSet row=st.executeQuery();
	while(row.next()) {
	System.out.println(row.getString(2));
	}
	
}


	}
  