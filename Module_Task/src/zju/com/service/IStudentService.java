package zju.com.service;

import zju.com.model.Student;

/**
 * @Autor:godfu
 * @Date:2021/11/29-18:34
 */
public interface IStudentService {
    /**
     * 对输入的信息按成绩从高到低排序
     * @return 排完序的对象数组
     */
    public Student[] sortAsScore();

    /**
     * 追加数据保存到文件中
     * @param str 追加的数据
     */
    public void append(String str);
}
