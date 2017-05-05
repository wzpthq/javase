package javase.copy;

import javase.copy.deep.User;
import javase.copy.shallow.Car;
import javase.copy.shallow.Person;
import javase.copy.shallow.Shoe;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by wangzhiping on 17/5/4.
 */
public class CopyTest {

    // 基础数据类型没有浅拷贝，都是深拷贝
    @Test
    public void testBaseTypeCopy() throws CloneNotSupportedException {
        Person person = new Person(1, "wangzhiping");
        Person copyPerson =(Person) person.clone();

        assert person != copyPerson;
        copyPerson.setId(2);
        copyPerson.setName("wangzp");

        System.out.println(person);
        System.out.println(copyPerson);


    }

    @Test
    public void testReferenceCopy() throws CloneNotSupportedException {

        Shoe shoe = new Shoe(1);
        Car car = new Car(1, "BMW", shoe);

        Car copyCar = (Car)car.clone();

        assert car != copyCar;

        copyCar.getShoe().setId(2);

        System.out.println(car);
        System.out.println(copyCar);

        // 浅拷贝引用对象实际上是同一个对象
        assert car.getShoe() == copyCar.getShoe();
    }


    @Test
    public void testListCopy() throws CloneNotSupportedException {

        Car car = new Car(1, "BMW", new Shoe(1));
        car.setShoes(Arrays.asList(new Shoe(2),  new Shoe(3),  new Shoe(4)));

        Car copyCar = (Car)car.clone();

        // 拷贝对象不是原对象
        assert copyCar != car;

        /**
         * 浅拷贝条件下的 List,Set,Map集合是同一个集合，并且集合元素也是同一个对象
         */
        assert copyCar.getShoes() == car.getShoes();
        copyCar.getShoes().get(0).setId(20);

        System.out.println(car);
        System.out.println(copyCar);

        assert copyCar.getShoes().get(0) == car.getShoes().get(0);

    }

    /**
     * 测试深拷贝对象
     */
    @Test
    public void testDeepCopyByClone() throws CloneNotSupportedException {

        User user = new User();
        user.setId(1);
        user.setName("wangzhiping");
        user.setPerson(new Person(1, "ok"));
        user.setCars(Arrays.asList(new Car(1, "B1", new Shoe(1)),new Car(2, "B1", new Shoe(2)) ));

        User copyUser = (User)user.clone();

        assert user != copyUser;

        assert user.getPerson() != copyUser.getPerson();
        copyUser.getPerson().setId(2);

        assert user.getCars() != copyUser.getCars();

        // 因为Car中包含了Shoe，但是Car.clone没有实现为深拷贝，所以这里的拷贝是浅拷贝，因此是一个对象
        assert user.getCars().get(0) == copyUser.getCars().get(0);

        copyUser.getCars().get(0).getShoe().setId(10);

        System.out.println(copyUser);
        System.out.println(user);

    }

    /**
     * 通过序列化实现深拷贝
     */
    @Test
    public void testDeepCopyBySerializable() {

        User copyUser = null;
        User user = new User();
        user.setId(1);
        user.setName("wangzhiping");
        user.setPerson(new Person(1, "ok"));
        user.setCars(Arrays.asList(new Car(1, "B1", new Shoe(1)),new Car(2, "B1", new Shoe(2)) ));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (ObjectOutputStream oos = new ObjectOutputStream(bos)){

            oos.writeObject(user);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            copyUser = (User)ois.readObject();

            ois.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert user != copyUser;
        assert user.getPerson() != copyUser.getPerson();
        copyUser.getPerson().setId(2);
        assert user.getCars() != copyUser.getCars();
        assert user.getCars().get(0) != copyUser.getCars();

        copyUser.getCars().get(0).getShoe().setId(10);

        System.out.println(copyUser);
        System.out.println(user);


    }


}


