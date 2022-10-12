package page;
import pages.*;
import java.sql.*;
public class login {
	public static void main(String aa[])
	 {
	 }
	 public static boolean check(String name1,String pass1) {
	  try
	  {	  String name="",pass="";
	    
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup?autoReconnect = true & useSSL= false", "root","Hariharan@1");

	   Statement st=conn.createStatement();
	   
	   ResultSet rs = st.executeQuery("select password from signin where name = '"+name1+"';");

	   while(rs.next())
	   {
	    pass = rs.getString("password");
	   }
	   if (pass.equals(pass1)) {
		  return true;
	   }
	   else {
		   return false;
	   }
	  }
	  catch(Exception e)
	  {
		  return false;
	  }
    }
}
