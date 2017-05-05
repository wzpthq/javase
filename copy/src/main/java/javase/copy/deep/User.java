package javase.copy.deep;

import javase.copy.shallow.Car;
import javase.copy.shallow.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhiping on 17/5/5.
 */
public class User implements Cloneable, Serializable {

    private int id;

    private String name;

    private Person person;

    private List<Car> cars = new ArrayList<>();

    public User() {
    }

    public User(int id, String name, Person person, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.person = person;
        this.cars = cars;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", cars=" + cars +
                '}';
    }

    // 通过重写clone方法来实现深拷贝
    @Override
    public Object clone() throws CloneNotSupportedException {

        User obj = null;

        try {
            obj = (User)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 如果进行拷贝，那么会是浅拷贝状态
        obj.person = (Person)obj.person.clone();

        List<Car> copyCars = new ArrayList<>();
        copyCars.addAll(this.getCars());

        obj.setCars(copyCars);

        return obj;

    }
}
