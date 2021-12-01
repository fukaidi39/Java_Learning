package zju.task;

import java.io.*;

/**
 * @Autor:godfu
 * @Date:2021/11/27-10:26
 * 本程序主要实现文件夹的拷贝功能
 */
//定义一个文件处理类
class FileUtil{
    private File src;//源路径
    private File des;//目标路径
    public FileUtil(File src, File des){
        this.src = src;
        this.des = des;
    }
    //提供路径构造的方法
    public FileUtil(String src, String des){
        this(new File(src), new File(des));
    }
    public boolean copyDir(){
        try {
            copyDirImpl(this.src);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean copyFile() throws IOException {
        if (this.src.exists()){//源文件存在
            copyFileImpl(this.src, this.des);
            return true;
        }else{
            return false;
        }
    }
    //定义内部文件夹拷贝实现类
    private void copyDirImpl(File file) throws IOException {
        if (file.isDirectory()){//是文件夹
            File results[] = file.listFiles();
            for (int i = 0; i < results.length; i++) {
                copyDirImpl(results[i]);//递归调用
            }
        }else{//是文件
            String filePath = file.getPath().replace(this.src.getPath() + "\\","");
            File newfile = new File(this.des, filePath);
            copyFileImpl(file, newfile);
        }
    }
    //定义文件拷贝实现类
    private void copyFileImpl(File srcFile, File desFile) throws IOException {
        if(!desFile.getParentFile().exists()){//判断父目录是否存在
            desFile.getParentFile().mkdirs();
        }
        //文件读写操作实现
        InputStream input = null;
        OutputStream output = null;
        byte data[] = new byte[1024];//每次读取1kB内容
        try {
            //数据流开启
            int length = 0;
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            while((length = input.read(data)) != -1){
                output.write(data);
            }
        }catch (Exception e){
            throw e;
        }finally {
            input.close();//关闭资源
            output.close();
        }
    }


}

public class IOCopy {
    public static void main(String[] args) throws IOException {
        if (args.length != 2){
            System.out.println("请输入正确的源文件和目标路径！");
        }
        FileUtil fu = new FileUtil(args[0], args[1]);
        long start = System.currentTimeMillis();
        if(new File(args[0]).isFile()){//如果是文件
            System.out.println(fu.copyFile()?"文件拷贝成功！" : "文件拷贝失败！");
        }else{//如果是文件夹
            System.out.println(fu.copyDir()?"文件夹拷贝成功！" : "文件夹拷贝失败！");
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝完成时间："+ (end - start));
    }
}
