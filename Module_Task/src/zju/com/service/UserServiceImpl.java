package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/29-23:13
 */
public class UserServiceImpl implements IUserService{
    private static int count = 0;
    @Override
    public boolean isExit() {//检测控制
        return this.count <= 3;
    }

    @Override
    public boolean login(String username, String password) {
        this.count ++;
        return "Java".equals(username) && "fkdzju".equals(password);
    }
}
