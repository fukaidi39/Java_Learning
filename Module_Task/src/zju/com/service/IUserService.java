package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/29-23:10
 */
public interface IUserService {
    /**
     * 判断是否超过了三次错误输入
     * @return
     */
    public boolean isExit();

    /**
     * 判断是否登录成功
     * @param uesername:用户名
     * @param password：密码
     * @return
     */
    public boolean login(String uesername, String password);
}
