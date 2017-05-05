package javase.io.stream;

import org.junit.Test;

import java.io.*;

/**
 * 字节输出流
 * Created by wangzhiping on 17/5/4.
 */
public class OutputStreamTest {


    /**
     * 测试文件输出流，就是将字节内容写入到文件中
     * 写入格式：字节
     * 写入方式：文件
     */
    @Test
    public void testFileOutputStream() {

        try(FileOutputStream fos = new FileOutputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1.txt");) {
            // 写入的是字节
            fos.write("王志平".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @see java.io.DataOutputStream 写java的基础数据类型(byte,char,short,int,long,double,float,string)
     */
    @Test
    public void testDataOutputStream() {

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493883485680.txt"))){
            // 写入byte
            dos.writeByte(101);
            // 写入short
            dos.writeShort(102);
            // 写入int
            dos.writeInt(103);
            // 写入long
            dos.writeLong(104L);
            // 写入float
            dos.writeFloat(105f);
            // 写入double
            dos.writeDouble(106);
            // 写入string
            dos.writeUTF("107");
            // 写入boolean
            dos.writeBoolean(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 字节缓存写，一个block写不是一字节就写
    @Test
    public void testBufferedOutputStream() {

        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/wangzhiping/idea-workspace/javase/io/src/main/resources/file1493883501201.txt"))){

            bos.write("osdfdsfdsafdasfds".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
