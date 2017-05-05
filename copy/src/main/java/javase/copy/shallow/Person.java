package javase.copy.shallow;

import java.io.Serializable;

/**
 * Created by wangzhiping on 17/5/4.
 */
public class Person implements Cloneable, Serializable{

    private int id;

    private String name;

    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


