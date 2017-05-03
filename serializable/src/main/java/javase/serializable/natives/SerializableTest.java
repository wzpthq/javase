package javase.serializable.natives;

import javase.serializable.entities.Person;
import org.junit.Test;

import java.io.*;

class PersonTransient implements Serializable {

    private int id;

    private String name;

    // 在Serializable序列化结构下，如果这段被标识为transient那么表示该字段不做序列化操作，是一个临时存储在内存的值
    private transient int age;

    // 静态变量也是不能被序列化的
    private static String address = "上海";

    public PersonTransient() {

    }

    public PersonTransient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = "南昌";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "PersonTransient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + ", address=" + address +
                '}';
    }
}

/**
 * 测试Serializable序列化方式
 */
public class SerializableTest implements  Serializable {

    @Test
    public void test01() throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/wangzhiping/person.txt"));
        Person person = new Person(1, "王志平", 27);
        out.writeObject(person);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/wangzhiping/person.txt"));
        Person p = (Person)in.readObject();
        System.out.println(p);
        assert p.getId() == 1 && p.getName().equals("王志平") && p.getAge() == 27;
        in.close();
    }


    /**
     * 这里static会打印出来，原因是因为在同一个jvm，该static已经被jvm记录，如果是不同的jvm实例就不应该被打印出来
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testTransientAndStatic() throws IOException, ClassNotFoundException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/wangzhiping/person.txt"));
        PersonTransient person = new PersonTransient(1, "王志平", 27);
        out.writeObject(person);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/wangzhiping/person.txt"));
        PersonTransient p = (PersonTransient)in.readObject();

        System.out.println(p);
        assert p.getId() == 1 && p.getName().equals("王志平") && p.getAge() == 0;
        in.close();

    }

    @Test
    public void testRead() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/wangzhiping/person.txt"));
        PersonTransient p = (PersonTransient)in.readObject();

        System.out.println(p);
        assert p.getId() == 1 && p.getName().equals("王志平") && p.getAge() == 0;
        in.close();

    }

}
