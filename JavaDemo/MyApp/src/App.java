import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try {
            char c = (char) System.in.read();
            switch (c) {
                case 'b', 'B' -> backdupDB();
                case 'r', 'R' -> System.out.println();
                default -> System.out.println("输入错误！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void backdupDB() {
        String dbURL = "jdbc:sqlserver://192.168.7.10:1433;databasename=testdb; user=sa; password=sqlserverWj952; encrypt=true; trustServerCertificate=true";
        ArrayList<Student> ss = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection dbConn = DriverManager.getConnection(dbURL);
                    Statement stmt = dbConn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                Student s = new Student();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    s.setId(id);
                    String name = rs.getString("name");
                    s.setName(name);
                    BigDecimal score = rs.getBigDecimal("score");
                    s.setScore(score);

                    ss.add(s);
                }
            } catch (SQLException e) {
                System.out.print("读取数据库失败");
            }

        } catch (ClassNotFoundException e1) {
            System.out.println("初始化失败");
        }

        try (FileOutputStream fis = new FileOutputStream("d:\\backup.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fis)) {
                    for(Student s : ss) {
                        oos.writeObject(s);
                    }
        } catch(Exception e) {
            System.out.println("备份至文件失败");
        }
    }
}

class Student implements Serializable {
    private int id;
    private String name;
    private BigDecimal Score;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the score
     */
    public BigDecimal getScore() {
        return Score;
    }
    /**
     * @param score the score to set
     */
    public void setScore(BigDecimal score) {
        Score = score;
    }
}