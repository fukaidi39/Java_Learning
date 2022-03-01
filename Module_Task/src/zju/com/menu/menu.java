package zju.com.menu;

import zju.com.Factory.Factory;
import zju.com.service.IStringService;
import zju.com.util.InputUtil;

import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/29-16:57
 */
public class menu {
    private IStringService ss;

    public menu() {
        ss = Factory.getInstance("StringServiceImpl", IStringService.class);
        this.choosemenu();
    }

    public void choosemenu() {
        this.show();
        String select = InputUtil.getString("请选择：");
        switch (select) {
            case "0": {
                System.out.println("程序退出！");
                System.exit(1);
            }
            case "1": {
                String str = InputUtil.getString("请输入添加的字符串信息:");
                ss.append(str);
                this.choosemenu();
            }
            case "2": {
                String result[] = ss.reverse();
                System.out.println(Arrays.toString(result));
                this.choosemenu();
            }
            default: {
                System.out.println("输入错误，请选择正确选项");
                this.choosemenu();
            }
        }
    }

    public void show() {
        System.out.println("【1】追加字符串");
        System.out.println("【2】逆序显示所有字符串");
        System.out.println("【0】退出程序");
    }

}