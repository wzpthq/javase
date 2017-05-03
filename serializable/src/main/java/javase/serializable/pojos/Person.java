package javase.serializable.pojos;

import java.io.Serializable;

/**
 * 实现Serializable接口，默认jvm会实现
 * Created by wangzhiping on 17/5/3.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 2L;

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
