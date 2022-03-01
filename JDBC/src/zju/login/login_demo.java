package zju.login;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Autor:godfu
 * @Date:2022/3/1-10:40
 */
public class login_demo {
    public static void main(String[] args) {
        //初始化用户界面
        Map<String, String> userInfo = initUI();
        //验证用户名和密码
        boolean login = login(userInfo);
        System.out.println(login ? "登录成功":"登录失败");
    }

    /**
     * 初始化界面
     * @return 用户名和密码
     */
    private static Map<String,String> initUI() {
        Scanner sc = new Scanner(System.in);//键入数据
        System.out.print("用户名:");
        String userName = sc.nextLine();
        System.out.print("密码:");
        String userPwd = sc.nextLine();
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("userName", userName);
        userInfo.put("userPwd", userPwd);
        return userInfo;
    }

    /**
     * 用户登录
     * @param userInfo: 用户的登录信息
     * @return 登录成功或失败
     */
    private static boolean login(Map<String,String> userInfo) {
        //获取用户数据名与密码
        String userName = userInfo.get("userName");
        String userPwd = userInfo.get("userPwd");
        //JDBC连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //读取资源文件
        ResourceBundle rc = ResourceBundle.getBundle("zju.resource.jdbc");
        String driver = rc.getString("driver");
        String url = rc.getString("url");
        String user = rc.getString("user");
        String password = rc.getString("password");
        boolean login = false;
        try {
            //1.注册驱动
            Class.forName(driver);
            //2.获取数据库连接对象
            conn = DriverManager.getConnection(url, user, password);
            //3.获取预编译数据库处理对象
            //SQL语句框架，一个？代表一个占位符，将来接受值
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            //程序执行到此处，会发送sql语句框架给DBMS，然后DBMS进行sql语句的预编译
            ps = conn.prepareStatement(sql);
            //给占位符?传值(第一个问好下标是1，第二个是2，JDBC所有下标从1开始)
            ps.setString(1,userName);//有setInt()   setDate()方法
            ps.setString(2, userPwd);
            //4.执行sql语句
            rs = ps.executeQuery();
            //查询到存在
            if(rs.next()){
                login = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(ps != null){
                    ps.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return login;
    }
}
