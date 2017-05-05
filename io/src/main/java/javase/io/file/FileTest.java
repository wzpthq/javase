package javase.io.file;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 关于文件对象的使用
 * Created by wangzhiping on 17/5/4.
 */
public class FileTest {

    @Test
    public void testCreateFile() throws FileAlreadyExistException, IOException {
        File file = FileUtils.createFile("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file" + System.currentTimeMillis() + ".txt");
        System.out.println(file.getName());
    }

    @Test
    public void testCreateDirectory() throws FileAlreadyExistException {
        // FileUtils.createDirs("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/students/E001", true);
        // FileUtils.createDirs("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/students/E002", true);
        // FileUtils.createDirs("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/students/E003", true);
        FileUtils.createDirs("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/student1/E004", false);
    }

    @Test
    public void testGetFiles() {

        // 获取所有的目录
        String[] names = FileUtils.getFileNames("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources", null);
        for (String name : names) {
            System.out.println(name);
        }

        // 过滤掉file开头的文件
        String[] names1 = FileUtils.getFileNames("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources", new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.contains("file");
            }
        });

        for (String name : names1) {
            System.out.println(name);
        }

    }

}



