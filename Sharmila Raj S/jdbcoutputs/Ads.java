package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class Ads {
	static boolean res=true;
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome!!!...........");
		do {
		System.out.println("1.read/n2.insert/n3.delete/4.update");
		System.out.println("Enter the option:");
		int option=sc.nextInt();
		
		switch (option) {
		case 1: {
			
			readRecords();
			break;
		}
		case 2:{
			insertRecord();
			break;
		}
		case 3:{
			deleteRecord();
			break;
		}
		case 4:{
			updateRecords();
			break;
		}
		case 5:{
			System.out.println("Enter the valid input");
			res=false;
			break;
			
		}
		default:
			System.out.println("Thankyou!!!!!!........");
		
		}
		}while(res);
	
	
		
		
		
		
		
		
		
		
	}
	public static void readRecords()throws Exception {
		String url= "jdbc:mysql://localhost:3306/ads";
		String userName="root";
		String pwd="root";
		String query="select * from developers";
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while (rs.next()) {
		System.out.println("Id is:"+rs.getInt(1));
		System.out.println("Name is:"+rs.getString(2));
		System.out.println("Salary is:"+rs.getInt(3));
		}
		con.close();
		
		
	}
    
    
    public static void insertRecord()throws Exception{
    	String url= "jdbc:mysql://localhost:3306/ads";
		String userName="root";
		String pwd="root";
		
		int id=13;
		String name="Shalini";
		int sal=15000;
		String query="insert into developers values(?,?,?)";
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, sal);
		int rows = ps.executeUpdate();
		
		System.out.println("Number of rows Affected:"+rows);
		con.close();
		
	
		
	}
    public static void deleteRecord()throws Exception {
    	String url= "jdbc:mysql://localhost:3306/ads";
		String userName="root";
		String pwd="root";
		int id =8;
		String query="delete from developers where d_id="+id;
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		Statement st=con.createStatement();
		int drows= st.executeUpdate(query);
		
		System.out.println("No of rows deleted:"+drows);
		con.close();
		
    }
    public static void updateRecords()throws Exception {
    	String url= "jdbc:mysql://localhost:3306/ads";
		String userName="root";
		String pwd="root";
		
		String query="update developers set sal=200000 where d_id=1";
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		Statement st=con.createStatement();
		int drows= st.executeUpdate(query);
		
		System.out.println("No of rows updated:"+drows);
		con.close();
	
    	
    }
    

}
