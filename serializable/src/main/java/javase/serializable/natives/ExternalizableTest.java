package javase.serializable.natives;

import javase.serializable.entities.User;
import org.junit.Test;

import java.io.*;

/**
 * @see java.io.Externalizable
 * Created by wangzhiping on 17/5/3.
 */
public class ExternalizableTest {

    @Test
    public void testNormal() throws IOException, ClassNotFoundException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/wangzhiping/user.txt"));
        User user = new User(1, "wangzhiping", 27, "shanghai");
        out.writeObject(user);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/wangzhiping/user.txt"));
        User u = (User)in.readObject();
        System.out.println(u);
        in.close();

    }



}
