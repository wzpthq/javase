package javase.serializable.entities;

import java.io.*;

/**
 * 实现Serializable接口，默认jvm会实现
 * Created by wangzhiping on 17/5/3.
 */
public class User implements Externalizable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private int age;

    private transient String address;

    public User() {

    }

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    // 定义需要进行序列化的字段
    /**
     * 如果是transient字段，也可以序列化，只需要指定就可以；
     * 如果没有指定的字段，那么是不能被序列化出来的
     * @param out
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(this.id);
        out.writeObject(this.name);
        out.writeObject(this.address);

    }

    // 一般与写入保持一直，顺序保持一致即可
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = (Integer)in.readObject();
        this.name = (String)in.readObject();
        this.address = (String)in.readObject();

    }
}
