package zju.com.menu;

import zju.com.Factory.Factory;
import zju.com.model.Student;
import zju.com.service.IStudentService;
import zju.com.util.InputUtil;

import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/29-21:09
 */
public class StudentMenu {
    private IStudentService ss;
    public StudentMenu(){
        this.choose();
    }
    public void choose(){
        this.show();
        String choice = InputUtil.getString("请进行选择");
        switch (choice){
            case "0":{
                System.out.println("退出程序");
                System.exit(1);
            }
            case "1":{
                ss = Factory.getInstance("StudentServiceImpl", IStudentService.class);
                String content = InputUtil.getString("请输入学生信息([格式]姓名:成绩)：");
                ss.append(content);
                choose();
            }
            case "2":{
                ss = Factory.getInstance("StudentServiceImpl", IStudentService.class);
                Student result[] = ss.sortAsScore();
                System.out.println(Arrays.toString(result));
                choose();
            }
            default:{
                System.out.println("请输入正确的选项");
                choose();
            }

        }
    }
    public void show(){
        System.out.println("【1】继续存入数据");
        System.out.println("【2】显示所有学生数据");
        System.out.println("【0】结束程序");
    }

}
