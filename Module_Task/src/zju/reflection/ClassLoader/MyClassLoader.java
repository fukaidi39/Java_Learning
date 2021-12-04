package zju.reflection.ClassLoader;

import java.io.*;

/**
 * @Autor:godfu
 * @Date:2021/12/4-10:25
 */
public class MyClassLoader extends ClassLoader{
    private static final File MessageFile = new File("E:\\Message.class");
    /**
     * 进行指定类的加载
     * @param className ：类的完整名称：包.类
     * @return：返回一个指定类的class对象
     */
    public Class<?> loadData(String className) throws Exception {
        byte data[] = this.loadClassData();//读取到了数据
        if(data != null){
            return super.defineClass(className,data,0,data.length);//转换为类结构
        }
        return null;
    }
    private byte[] loadClassData() throws Exception {//通过文件进行类的加载
        InputStream input = new FileInputStream(MessageFile);
        ByteArrayOutputStream output = new ByteArrayOutputStream();//内存流
        byte data[] = new byte[1024];
        int length = 0;
        while((length = input.read(data))!=-1){//读取数据
            output.write(data,0,length);//保存入内存
        }
        byte result[] = output.toByteArray();
        input.close();
        output.close();
        return result;
    }

}
