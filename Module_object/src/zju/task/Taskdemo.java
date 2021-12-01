package zju.task;

import java.util.Arrays;

/**
 * @Autor:godfu
 * @Date:2021/11/22-9:49
 */
class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;
    public Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+" 年龄："+this.age+" 成绩："+this.score;
    }

    @Override
    public int compareTo(Student stu) {
        if(this.score > stu.score){//从高到低
            return -1;//正常逻辑是this.score - stu.score
        }else if(this.score < stu.score){
            return 1;
        }else{
            return this.age - stu.age;
        }
    }
}

public class Taskdemo {
    public static void main(String[] args) {
        //想要排序，调用Arrays.sort(object[] obj);
        String input = "张三:21:98|李四:22: 89|王五:20:70";
        String data[] = input.split("\\|");
        Student student[] = new Student[data.length];//生成对象数组
        for (int i = 0; i < data.length; i++) {
            String temp[] = data[i].split(":");
                student[i] = new Student(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
        }
        Arrays.sort(student);
        for(Student temp : student){
            System.out.println(temp);
        }
    }
}

