import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://192.168.7.10:1433; DatabaseName=testdb; encrypt=true; trustServerCertificate=true"; // 连接字符串
        // String dbURL = "jdbc:mysql://192.168.7.10:3306/testDB";
        String userName = "sa";
        // String userName = "root";
        String userPwd = "sqlserverWj952";
        // String userPwd = "mysqlWj952";

        Connection dbConn = null;
        Statement stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Class.forName("com.mysql.cj.jdbc.Driver");
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功");
            stmt = dbConn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                BigDecimal score = rs.getBigDecimal("score");
                System.out.println(id + "\t" + name + "\t" + score.intValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("连接失败");
        } finally {
            try {
                stmt.close();
            dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}