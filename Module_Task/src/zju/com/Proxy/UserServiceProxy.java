package zju.com.Proxy;

import zju.com.service.IUserService;
import zju.com.util.InputUtil;

/**
 * @Autor:godfu
 * @Date:2021/11/29-23:23
 */
//定义IUserService的代理类，负责其中的代理业务
public class UserServiceProxy implements IUserService {
    private IUserService isu;

    public UserServiceProxy(IUserService isu) {
        this.isu = isu;//初始化时传入核心业务
    }


    @Override
    public boolean isExit() {
        return this.isu.isExit();
    }

    @Override
    public boolean login(String uesername, String password) {
        while (this.isExit()) {
            String str = InputUtil.getString("请输入用户名和密码:");
            if (str.contains("/")) {
                String data[] = str.split("/");
                if (isu.login(data[0], data[1])) {//匹配成功
                    System.out.println("登录成功！");
                    return true;//有返回，直接结束循环
                } else {
                    System.out.println("登录失败，请输入正确的用户名及密码。");
                }
            }else{//只有用户名
                String pw = InputUtil.getString("请输入密码:");
                if(isu.login(str, pw)){
                    System.out.println("登录成功！");
                    return true;
                }else{
                    System.out.println("登录失败，请输入正确的用户名密码。");
                }
            }

        }
        return false;
    }
}
