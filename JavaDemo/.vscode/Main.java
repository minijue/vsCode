import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
public static void main(String[]args)
throws Exception{ 
System.out.println("请输入(B备份数据表,R恢复数据表):"); 
Scanner scanner =new Scanner(System.in);
String input =null; 
while(input ==null){ input = scanner.next();
 if("B".equals(input)||"R".equals(input)) break; 
}else{ input =null; 
    
String ip="127.0.0.1"; 
int port = 3306; 
String dbName ="cs"; 
String tableName ="user"; 
String userName ="root"; 
String password ="123456"; 
String savePath ="e:/backup.txt";
String url=String.format("jdbc:mysql://%s:%s/%s? characterEncoding=utf-8",ip,port,dbName); Class.forName("com.mysql.cj,jdbc.Driver"); if("B".equals(input)){ 
Connection connection =null; 
PreparedStatement preparedstatement = null; 
ResultSet result = null; 
try{
connection = DriverManager.getConnection(url,userName,pa String selectAllSql= "select id,name,score"from "+tableName;
preparedStatement =connection.prepareStatement(selectAllSql);
resultSet = preparedStatement.executeQuery(): 
List<String>list = new ArrayList();
while(resultSet.next()) 
int id = resultSet.getString("name"); 
double score = resultSet.getDouble("score");
list.add(id+""+name+","+score);
 if(list.size()>0) {
FileOutputStream fileOutputStream = null; 
OutputStreamWriter outputStream = null; 
BufferedWriter bufferedWriter = null; 
try{ 
fileOutputStream = new FileOutputStream(savePath); 
outputStreamWriter =new OutputStreamWriter(fileOutputStream,"utf-8");
bufferedWriter =new BufferedWriter(outputScreamWriter);
for(String s :list) bufferedWriterwrite(s+"\r\n"); }
}catch (Exception e) {System.err.println("备份数据异常") throw e; }finally {
if(bufferedWriter !=null) {bufferedWriter.close();} 
if(outputStreamWriter !=null) outputStreamWriter.close();}} 
}else{FilelnputStream filelnputStream = null) }
InputStreamReader inputStreamReader = null;
BufferedReader bufferedReader = null;
Set<String>set = new LinkedHashSet<>();
try{ 
filelnputStream = new FilelnputStream(savePath); 
inputStreamReader = new InputStreamReader(filelnputStream,"utf-8");
bufferedReader = new BufferedReader(inputStreamReader);
while(line = bufferedReader.readLine())!=null); 
set.add(line); }catch(Exception e) {System.err.println(“备份文件读取失败) ;throw e; 
}finally{ 
if(filelnputStream !=null){filelnputStream.close(); }}
if(inputStreamReader != null){ inputStreamReader.close();} 
if(bufferedReader !=null) {bufferedReader.close();}}
Connection connection2 =null; 
PreparedStatement preparedStatement2 =null;
List<String> iList =new ArrayList<>();
if(set.size()>0) {
for (String s :set){
String[]split =s.split(","); 
StringBuilder sb = new StringBuilder();
iList.add(sb.append( (").append(split[0]).append(",\").append(split[1])("\,").append(split[2].append("(").toString());}
try{
connection2 =DriverManagergetConnection(url,userName,p connection2.setAutoCommit(false);
preparedStatement2 =connection2.prepareStatement("truncate "+tableName);     preparedStatement2.execute();
int count = 0;
for(String s : iList) {
preparedStatement2=connection2.prepareStatement("insert into"+tableName+"(id,name,score) values"+s);
preparedStatement2.execute();
if(preparedStatement2.getUpdateCount()>0)
{System.out.println(“插入一条数据成功:“+s);
 count++; }
else{ 
System.errprintln(“插入一条数据失败:“+s);}}
System.out.println(“读取数据数量:"+iList.size()+",实际恢复数据量:"+count);
if(iList.size()!=count{
connection2.rollback();
System.err.println(”恢复数据失败!") ;
}else{
connection2.commit(): 
System.out.println(“恢复数据成功") }catch (Exception e) throw e; 
}finally { if(preparedStatement2 !=null){ preparedStatement2.close();}
 if(connection2!=null) {connection2.close(); 
}}}else{
 System.out.println("备份文件数据为空");}}}}
