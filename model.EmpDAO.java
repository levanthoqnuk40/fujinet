package source;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  

public class EmpDao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersystem",
					"sa", "Abc12345");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
  
    public static List<Emp> getRecords(int start,int total){  
        List<Emp> list=new ArrayList<Emp>();  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setCustomer_id(rs.getString(1));  
                e.setCustomer_name(rs.getString(2));
                e.setSex(rs.getString(3));
                e.setBirthday(rs.getString(4));
                e.setAddress(rs.getString(5));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
}
