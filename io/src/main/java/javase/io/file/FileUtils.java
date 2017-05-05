package javase.io.file;

import java.io.*;

/**
 * 文件工具类
 * Created by wangzhiping on 17/5/4.
 */
public class FileUtils {


    /**
     * 创建文件
     * @param path 文件路径
     */
    public static File createFile(String path) throws FileAlreadyExistException, IOException {

        File file =  new File(path);

        if (file.exists()){
            throw new FileAlreadyExistException();
        }

        if (file.createNewFile()) {
            return file;
        }

        return null;
    }

    /**
     * 创建文件目录
     * @param path 文件目录
     * @param isLoop 是否循环创建多级目录
     */
    public static void createDirs(String path, boolean isLoop) throws FileAlreadyExistException {

        File file = new File(path);

        if (file.exists()){
            throw new FileAlreadyExistException();
        }

        if (isLoop) file.mkdirs();
        else file.mkdir();
    }


    /**
     * 获取目录下的所有文件列表
     * @return
     */
    public static File[] getFiles(String path, FileFilter fileFilter) {

        File file = new File(path);

        if(file.exists() && file.isDirectory()){ // 文件存在，并且是目录
            if (fileFilter == null) {
                return file.listFiles();
            }
            else {
                return file.listFiles(fileFilter);
            }

        }

        return new File[0];
    }

    /**
     * 获取目录下的所有文件名列表
     * @return
     */
    public static String[] getFileNames(String path, FilenameFilter filenameFilter) {

        File file = new File(path);

        if(file.exists() && file.isDirectory()){ // 文件存在，并且是目录
            if (filenameFilter == null) {
                return file.list();
            }else {
                return file.list(filenameFilter);
            }

        }

        return new String[0];
    }

    /**
     * 文件重命名
     */
    public static void rename(String src, String dist) throws FileNotFoundException{

        File srcFile = new File(src);

        if (!srcFile.exists()){
            throw new FileNotFoundException();
        }

        srcFile.renameTo(new File(dist));

    }

    /**
     * 获取文件大小
     */
    public static long getSpaceSize(String path) throws FileNotFoundException{

        File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file.getTotalSpace();

    }

    /**
     * 删除文件
     */
    public static boolean deleteFileOrDirectory(String path) throws FileNotFoundException {
        File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        return file.delete();
    }


    /**
     * 删除文件在虚拟机退出的时候
     */
    public static void deleteOnJvmExit(String path) throws FileNotFoundException {
        File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        file.deleteOnExit();
    }

    /**
     * 判断文件是否是绝对路径
     */
    public static boolean isAbsolutePath(String path) {
        return new File(path).isAbsolute();
    }


}
