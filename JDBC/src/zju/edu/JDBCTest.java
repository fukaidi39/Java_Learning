package zju.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Autor:godfu
 * @Date:2022/2/28-23:35
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取数据库预编译对象
            String sql = "select ename from emp  where ename like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_A%");
            //执行SQL
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}
