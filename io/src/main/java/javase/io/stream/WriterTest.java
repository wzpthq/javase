package javase.io.stream;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wangzhiping on 17/5/4.
 */
public class WriterTest {

    @Test
    public void testFileWriter() {

        try(FileWriter fileWriter = new FileWriter("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493882846078.txt")){
            fileWriter.write("测试FileWriter");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriter() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493882874461.txt"))){
            writer.write("测试BufferedWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
