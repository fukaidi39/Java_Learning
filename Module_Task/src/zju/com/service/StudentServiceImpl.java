package zju.com.service;

import zju.com.model.Student;
import zju.com.util.FileUtil;

import java.io.File;
import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/29-18:39
 */
public class StudentServiceImpl implements IStudentService{
    private String content; //读取的数据信息
    private static final File SAVE_FILE = new File("F:\\zju\\fkd.txt");
    public StudentServiceImpl(){
        this.content = FileUtil.load(SAVE_FILE);
    }
    @Override
    public Student[] sortAsScore() {
        String data[] = this.content.split("\\|");
        Student result[] = new Student[data.length];
        for (int i = 0; i < data.length; i++) {
            String temp[] = data[i].split(":");
            Student student = new Student(temp[0], Double.parseDouble(temp[1]));
            result[i] = student;
        }
        Arrays.sort(result);
        return result;
    }

    @Override
    public void append(String str) {
        //前后不能有"|"
        if(str.startsWith("|")){
            str.substring(1);
        }
        if(!str.endsWith("|")){
            str = str + "|";
        }
        FileUtil.append(SAVE_FILE, str);//将内容存入文件
    }
}
