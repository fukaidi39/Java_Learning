package zju.edu.JavaIO;

import java.io.*;

/**
 * @Autor:godfu
 * @Date:2021/11/27-21:54
 */
public class IODemo {
    private static final File SAVE_FILE = new File("F:\\zju\\Person");
    public static void main(String[] args) throws Exception {
//        savaObject(new Person("fkd",22));
        System.out.println(loadObject());
    }
    public static void savaObject(Object obj) throws IOException {//序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();
    }
    public static Object loadObject() throws IOException, ClassNotFoundException {//反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();//二进制转对象
        ois.close();
        return obj;
    }
}
class Person implements Serializable{
    private transient int age;
    private String name;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "姓名：" + this.name + "、年龄：" + this.age;
    }
}
