package com.springboot.springboot_restaurant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurantFunctions {

public Connection connect_to_db(String dbname, String user, String pass) {
	Connection conn = null;
	try {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
		if(conn!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection Failed");
		}
		}
	catch(Exception e) {
		
		System.out.println(e);
		}
		return conn;
	}

public void createTable(Connection conn, String table_name) {
	Statement statement;
	try
	{
		//if table_name 
		String query= "create table " +table_name+"(empid SERIAL, name varchar(200), address varchar(200),primary key(empid));";
		statement= conn.createStatement();
		statement.executeUpdate(query);
		System.out.println("Table Created");
		
	}
	catch (Exception e)
	{
		System.out.println(e);	}

}

public void insertRow(Connection conn, String table_name, String name, String address) {
	Statement statement;
	try {
		
		String query= String.format("insert info %s(name,address) values('%s','%s');",table_name,name,address);
		statement = conn.createStatement();
		statement.executeUpdate(query);
		System.out.println("Row Inserted");
	}
	
	catch(Exception e)
	{
		
	}
}

public void readData(Connection conn, String table_name)
{
	Statement statement;
	ResultSet rs = null;
	try {
		String query = String.format("select:* from %s", table_name);
		statement= conn.createStatement();
		rs=statement.executeQuery(query);
		while(rs.next())
		{
			System.out.print(rs.getString("empid")+ " ");
			System.out.print(rs.getString("name")+ " ");
			System.out.println(rs.getString("address"));

		}
	}
	catch (Exception e)
	{
	
	}
}

public void updateData(Connection conn, String table_name, String old_name, String new_name)
{
	Statement statement;
	try
	{
		String query=String.format("update %s set name= '%s' where name= '%s'",table_name,old_name,new_name );
		statement=conn.createStatement();
		statement.executeUpdate(query);
		System.out.println("Data updated");
		
	}
	catch (Exception e)
	{
		System.out.print(e);
	}
	
}

public void searchByName(Connection conn, String table_name, String name)
{
	Statement statement;
	ResultSet rs = null;
	try
	{
		System.out.println("Entered");
		String query = String.format("SELECT * FROM %s WHERE name = '%s'", table_name, name);
		statement= conn.createStatement();
		rs = statement.executeQuery(query);
		while(rs.next())
		{
			System.out.print(rs.getString("empid"));	
			System.out.print(rs.getString("name"));	
			System.out.print(rs.getString("address"));	
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

}
public void searchById(Connection conn, String table_name, int id)
{
	Statement statement;
	ResultSet rs = null;
	try
	{
		String query= String.format("select * from %s where empid =%s",table_name,id);
		statement= conn.createStatement();
		rs = statement.executeQuery(query);
		while(rs.next())
		{
			System.out.print(rs.getString("empid"));	
			System.out.print(rs.getString("name"));	
			System.out.print(rs.getString("address"));
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

}

public void deleteByName(Connection conn, String table_name, String name)
{
	Statement statement;
	System.out.println("Entered Delete");
	try
	{
		String query= String.format("delete from %s where name ='%s'",table_name,name);
		statement= conn.createStatement();
		statement.executeUpdate(query);
		System.out.println("Data Deleted");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

}


public void deleteTable (Connection conn, String table_name)
{
	Statement statement;
	try
	{
		String query= String.format("drop table %s",table_name);
		statement= conn.createStatement();
		statement.executeUpdate(query);
		System.out.println("Table Deleted");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

}

}
