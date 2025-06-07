package day1.com.cdac.sanket.web;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 Assignment 2 
Create a Java Console Application that allows the User to create a new table with columns in the database
1. Create Table
	-> Accept the Table Name
	->loop the below till Save is selected
	a. Add column
		->Accept the column name
		-> show a list of standard types (VARCHAR, INT,FLOAT)
		
-> ask him to select an option this will be the datatype to be used for the column
	b. Set Primary Key
	
->Show all the columns above and ask him to select the column to act as a primary key
	c. Save
	->this will result in saving the Table to the underlying database
	
2. Display Columns of a Table
-> Accept the name of the table and show Only the column names in that table

 */
public class Assignment2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection dbconnection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			dbconnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advjavab2", "root", "root");
			System.out.println(
					"********************************" + "\nEnter 1 to Add table" + "\nEnter 2 to display table columns"
							+ "\nEnter to exit" + "\n**********************************");
//			addTable(sc, dbconnection);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addTable(sc, dbconnection);
				break;
			case 2:
				displayTable(sc, dbconnection);
				break;
			case 0:
				System.out.println("Exiting........");
				break;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void addTable(Scanner sc, Connection dbconnection) {
		System.out.println("Enter Table Name");
		String tableName = sc.next();
		StringBuilder query = new StringBuilder("Create table " + tableName);
		query.append("(");
		boolean choice = true;
		while (choice) {
			System.out.println("Enter column name");
			query.append(sc.next());
			System.out.println("\n*****************************");
			System.out.println("Enter :1 for INT,"
					+ " \nEnter:2 for VARCHAR(50),"
					+ "\nEnter :3 for FLOAT");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				query.append(" INT");
				break;
			case 2:
				query.append(" VARCHAR(50)");
				break;
			case 3:
				query.append(" FLOAT");
				break;
			}
			System.out.println("Do you want to add more columns y/n");
			String ans = sc.next();
			if (ans.equalsIgnoreCase("n")) {
				choice = false;
				query.append(",");
				System.out.println("Enter column name you want to set as primary key");
				String key = sc.next();
				query.append("PRIMARY KEY (" + key + ") );");

				try {
					PreparedStatement statement = dbconnection.prepareStatement(query.toString());
					statement.executeUpdate();
					System.out.println("Table added successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				query.append(",");
			}

		}

	}

	private static void displayTable(Scanner sc, Connection dbconnection) {
		System.out.println("Enter name of table ");
		String tableName = sc.next();
		try {
			DatabaseMetaData metaData = dbconnection.getMetaData();
			ResultSet columns = metaData.getColumns(null, "users", tableName, null);
			while (columns.next()) {
				System.out.println(columns.getString("COLUMN_NAME"));
				System.out.println("_______________________");
			}
//		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
