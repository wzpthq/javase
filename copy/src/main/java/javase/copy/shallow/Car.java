package javase.copy.shallow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiping on 17/5/4.
 */

public class Car implements Cloneable, Serializable {

    private int id;

    private String name;

    private Shoe shoe;

    private List<Shoe> shoes = new ArrayList<>();

    public Car() {}

    public Car(int id, String name, Shoe shoe) {
        this.id = id;
        this.name = name;
        this.shoe = shoe;
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

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shoe=" + shoe +
                ", shoes=" + shoes +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}