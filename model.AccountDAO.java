package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	public static boolean checkLogin(String userid, String password) {
		boolean isValid = false;
		try {
			// load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// mo ket noi den csdl
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=customersystem",
					"sa", "Abc12345");

			String sql = "select count(*) as cnt from mstuser where delete_ymd IS NULL and userid=? and password=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, userid);
			pre.setString(2, password);

			// thuc thi cau lenh truy van trong csdl
			ResultSet rs = pre.executeQuery();

			// truong hop dang nhap thanh cong
			if (rs.next()) {
//				isValid=true;
				int n = rs.getInt("cnt");
				if (n == 1) {
					isValid = true;
				} else {
					isValid = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

}
