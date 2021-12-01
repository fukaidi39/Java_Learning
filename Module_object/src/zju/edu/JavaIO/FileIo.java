package zju.edu.JavaIO;


import java.io.*;

/**
 * @Autor:godfu
 * @Date:2021/11/23-20:23
 */
class FileUtil{
    private File srcFile;//源文件路径
    private File desFile;//目标文件路径

    public FileUtil(File srcFile, File desFile){
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    public FileUtil(String src, String des){
        this(new File(src), new File(des));//构造方法有this先执行
    }
    public boolean copyDir() {//拷贝整个文件夹
        try {
            this.copyDirImpl(this.srcFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean copyFile() throws Exception {//拷贝单个文件
        if(!srcFile.exists()){//源文件不存在
            return false;
        }
        copyFileImpl(this.srcFile,this.desFile);
        return true;
    }
    private void copyDirImpl(File file) throws Exception {//拷贝文件夹内部实现
        if(file.isDirectory()){//是一个文件夹
            File[] results = file.listFiles();
            if(results != null) {
                for (int i = 0; i < results.length; i++) {
                    copyDirImpl(results[i]);//递归
                }
            }
        }else{//是一个文件
            String Filepath = file.getPath().replace(this.srcFile.getPath()+File.separator,"");
            File newFile = new File(this.desFile, Filepath);//父路径+子路径地址
            this.copyFileImpl(file , newFile);
        }
    }

    private void copyFileImpl(File srcFile, File desFile) throws Exception {//拷贝单个文件实现
        if(! desFile.getParentFile().exists()){//如果父目录不存在
            desFile.getParentFile().mkdirs();
        }
        InputStream input = null;
        OutputStream output = null;
        byte data[] = new byte[1024];//定义每次读取数据范围
        try {
            int length = 0;//定义每次读取长度
            input = new FileInputStream(srcFile);//定义输入流对象
            output = new FileOutputStream(desFile);//定义输出流对象
            //先读出数据到data数组，返回读取的个数。
            // 判断数据是否是-1，再将数据写入
            while((length = input.read(data)) != -1){
                output.write(data,0, length);
            }
        }catch(Exception e){
            throw e;
        }finally{
            input.close();
            output.close();
        }
    }

}
public class FileIo {
    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("输入命令错误，请输入争取的源文件路径和目标文件路径。");
            System.exit(1);//退出程序
        }
        long start = System.currentTimeMillis();
        FileUtil fu = new FileUtil(args[0],args[1]);
        if(new File(args[0]).isFile()){
            System.out.println(fu.copyFile()?"文件拷贝成功！" : "拷贝失败！");
        }else {
            System.out.println(fu.copyDir()?"文件夹拷贝成功！" : "拷贝失败！");
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝完成时间：" + (end - start));
    }
}
