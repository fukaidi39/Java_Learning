package zju.com.model;

/**
 * @Autor:godfu
 * @Date:2021/11/29-18:28
 */
public class Student implements Comparable<Student>{
    private String name;
    private double score;
    public Student(){}
    public Student(String name, double score){
        this.name = name;
        this.score = score;
    }
    @ Override
    public String toString(){
        return "姓名："+this.name+"、成绩："+this.score;
    }


    @Override
    public int compareTo(Student stu) {
        if(this.score > stu.score){
            return -1;
        }else if(this.score < stu.score){
            return 1;
        }else{
            return 0;
        }
    }
}
