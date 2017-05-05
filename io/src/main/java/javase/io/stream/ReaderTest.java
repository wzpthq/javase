package javase.io.stream;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by wangzhiping on 17/5/4.
 */
public class ReaderTest {

    @Test
    public void testInputStreamReader() {
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1.txt"))){

            char[] buffer = new char[1024];
            int c = 0;
            int len = 0;
            while((c = reader.read()) != -1){
                buffer[len] = (char)c;
                len ++;
            }

            System.out.println(new String(buffer, 0, len));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileReader() {

        try(FileReader fileReader = new FileReader("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493882846078.txt")){
            StringBuffer stringBuffer = new StringBuffer();

            CharBuffer buffer = CharBuffer.allocate(1024);
            while(fileReader.read(buffer) != -1){
                stringBuffer.append(buffer);
                buffer.flip().clear();
            }

            System.out.println(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFileReaderForCharRead() {

        try(FileReader fileReader = new FileReader("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493882846078.txt")){
            StringBuffer stringBuffer = new StringBuffer();
            char[] buffer = new char[1024];

            int c = 0;

            while((c = fileReader.read()) != -1) {
                stringBuffer.append((char)c);
            }

            System.out.println(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBufferedReader() {

        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493882874461.txt"))) {

            StringBuffer buffer = new StringBuffer();
            String tmp = "";
            while((tmp = reader.readLine()) != null ){
                buffer.append(tmp);
            }

            System.out.println(buffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
