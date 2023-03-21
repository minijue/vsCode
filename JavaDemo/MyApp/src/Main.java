import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("【 注：输入B备份数据表/输入R恢复数据表 】");
        // 输入 R 时恢复数据表，将备份在文件中的数据恢复出来 
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请【 输入B备份数据表/输入R恢复数据表】：");
        String next = scanner.next();
        if (next.equals("R")) {
            File f = new File("D:\\a.txt");
            FileReader fre = new FileReader(f);
            BufferedReader bre = new BufferedReader(fre);
            String str = "";
            while ((str = bre.readLine()) != null) {
                students.add(str);
            }
            bre.close();
            fre.close();
            // 将读取出来的文件中的数据赋给下面的属性 
            String student_name = students.get(0);
            String student_xb = students.get(1);
            String student_class = students.get(2);
            System.out.println("====== 恢复的数据如下 ======");
            System.out.println(student_name);
            System.out.println(student_xb);
            System.out.println(student_class);
            System.out.println("==========================");
            System.out.println("数据恢复成功");
        }
        // 输入B的时候备份数据表到student数据库当中 
        else if (next.equals("B")) {
            // 加载配置文件
            Properties prop = new Properties();
            prop.load(new FileInputStream("druid.properties"));
            // 把读出来的properties文件 加载到prop集合中 
            // 4.获取数据库连接池对象 conn
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            // 5.获取数据库连接 Connection
            Connection conn = dataSource.getConnection();
            // 定义SQL语句
            String sql = "insert into student(student_name,student_xb,e,student_class,c) values(?,?,?,?,?)";
            // 获取执行sql的对象
            PreparedStatement pt = conn.prepareStatement(sql);
            File f = new File("D:\\a.txt");
            FileReader fre = new FileReader(f);
            BufferedReader bre = new BufferedReader(fre);
            String str = "";
            while ((str = bre.readLine()) != null) {
                students.add(str);
            }
            bre.close();
            fre.close();
            // 将读取出来的文件中的数据赋给下面的属性 
            String student_name = students.get(0);
            String student_xb = students.get(1);
            String student_class = students.get(2);
            int e = 1;
            int c = 1;
            System.out.println(student_name);
            // 设置参数 
            pt.setString(1, student_name);
            pt.setString(2, student_xb);
            pt.setInt(3, e);
            pt.setString(4, student_class);
            pt.setInt(5, c);
            System.out.println(student_name);
            // 执行SQL 
            int Count = pt.executeUpdate();
            // 处理结果 
            System.out.println(Count > 0);
            // 受影响行数大于0 说明插入数据成功    为0 说明失败*/ 
            System.out.println("数据备份成功");
        }
    }
}