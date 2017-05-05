package javase.copy.shallow;

import java.io.Serializable;

/**
 * Created by wangzhiping on 17/5/4.
 */
public class Shoe implements Serializable{

    private int id;

    public Shoe() {
    }

    public Shoe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                '}';
    }
}
