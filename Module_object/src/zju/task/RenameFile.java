package zju.task;

import java.io.File;
import java.util.UUID;

/**
 * @Autor:godfu
 * @Date:2021/11/28-9:46
 */
class FileRename{
    public void rename(File file){
        if(file.isDirectory()){//是目录
            File results[] = file.listFiles();
            for (int i = 0; i < results.length; i++) {
                this.rename(results[i]);//递归
            }
        }else{//是文件
            String newFileName = null;
            newFileName = UUID.randomUUID() + ".png";
            File newFile = new File(file.getParentFile(), newFileName);//新文件
            file.renameTo(newFile);
        }
    }
}
public class RenameFile {
    public static void main(String[] args) {
        File file = new File("F:\\文件管理\\Java笔记\\笔记\\图片");
        FileRename fn = new FileRename();
        long start = System.currentTimeMillis();
        fn.rename(file);
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end - start));

    }
}
