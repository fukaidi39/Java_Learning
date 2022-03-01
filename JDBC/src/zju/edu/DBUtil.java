package zju.edu;

import java.sql.*;

/**
 * @Autor:godfu
 * JDBC工具类,简化JDBC编程
 * @Date:2022/3/1-19:30
 */
public class DBUtil {
    /**
     * 工具类中的构造方法都是私有的
     * 工具类中的方法都是静态的，可以直接通过类名调用
     */
    private DBUtil(){
    }
    //静态代码块在类被加载时执行，并且只执行一次
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接对象
     * @return
     */
     public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/fkddatabase","root","123456");
     }

    /**
     * 关闭资源
     * @param conn 连接对象
     * @param stmt 数据库连接对象
     * @param rs 查询结果集对象
     */
     public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
         try {
             if(stmt != null){
                 stmt.close();
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         try {
             if(rs != null){
                 rs.close();
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
     }
}
