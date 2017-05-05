package javase.io.stream;

import org.junit.Test;

import java.io.*;

/**
 * 字节输入流
 * Created by wangzhiping on 17/5/4.
 */
public class InputSteamTest {


    // 测试文件输入流
    @Test
    public void testFileInputSteamForRead(){

        try(FileInputStream fis = new FileInputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1.txt")){
            // 存放数据
            byte[] buffer = new byte[1024];

            int b = 0;
            int len = 0;
            // 一个一个数据读取
            while((b = fis.read()) != -1){
                buffer[len] = (byte)b;
                len ++;
            }

            String str = new String(buffer, 0, len);

            System.out.println(str);

            assert "王志平".equals(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 测试文件输入流
    @Test
    public void testFileInputSteamForReadBytes(){

        try(FileInputStream fis = new FileInputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1.txt")){
            // 存放数据
            byte[] buffer = new byte[fis.available()];

            // fis.read(buffer);
            fis.read(buffer, 0, buffer.length);

            String str = new String(buffer, 0, buffer.length);

            System.out.println(str);

            assert "王志平".equals(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDataInputStream() {
        // 保持写入+读取顺序
        try(DataInputStream dis = new DataInputStream(new FileInputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493883485680.txt"))){
            System.out.println(dis.readByte());
            System.out.println(dis.readShort());
            System.out.println(dis.readInt());
            System.out.println(dis.readLong());
            System.out.println(dis.readFloat());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBufferedInputStream() {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493883501201.txt"))){

            byte[] buffer = new byte[bis.available()];
            bis.read(buffer);

            System.out.println(new String(buffer));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
