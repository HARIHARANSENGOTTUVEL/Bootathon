package page;
import java.sql.*;
import pages.*;
public class mysqllink {
	 public static void main(String aa[])
	 {
	 }
	 public static void update(String name,String age,String number,String emailid,String password) {
	  try
	  {
		  String s1=name;
		  String s2=age;
		  String s3=number;
		  String s4=emailid;
		  String s5=password;
		  
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup?autoReconnect = true & useSSL= false", "root","Hariharan@1");

	   Statement st=conn.createStatement();

	   st.executeUpdate("insert into signin values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"');");

	   conn.close();
	   System.out.println("Success!");
	  }
	  catch(Exception e)
	  {
	   System.out.println("     "+e);
	  }
     }
}

