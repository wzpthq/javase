package javase.serializable.entities;

import java.io.Serializable;

/**
 * 实现Serializable接口，默认jvm会实现
 * Created by wangzhiping on 17/5/3.
 */
public class Person implements Serializable {

    // 如果明确了可序列话化的结构，C端和S端的同一个类的serialVersionUID的版本不一致，那么不能反序列化
    // 主要用于上下兼容
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private int age;

    public Person() {

    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
