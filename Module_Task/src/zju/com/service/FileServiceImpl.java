package zju.com.service;

import zju.com.util.InputUtil;

import java.io.*;

/**
 * @Autor:godfu
 * @Date:2021/11/29-13:17
 */
public class FileServiceImpl implements IFileService{
    private String filename;
    private String content;
    public FileServiceImpl()  {
        this.filename = InputUtil.getString("请输入文件名：");
        this.content = InputUtil.getString("请输入文件内容：");
    }
    @Override
    public boolean save(){
        File file = new File(IFileService.SAVE_DIR + this.filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(file));
            pw.print(this.content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally{
            pw.close();
        }
        return true;
    }
}
