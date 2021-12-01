package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/29-13:13
 */
public interface IFileService {
    public static final String SAVE_DIR = "F:\\zju\\";

    /**
     * 定义文件的保存方法
     * @return 文件保存成功返回true; 否则false
     */
    public boolean save();
}
