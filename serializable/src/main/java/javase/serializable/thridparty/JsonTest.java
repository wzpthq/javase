package javase.serializable.thridparty;

import javase.serializable.entities.User;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wangzhiping on 17/5/3.
 */
public class JsonTest {

    @Test
    public void testObject2Json() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        jsonGenerator.writeObject(new User(1, "wangzhiping", 27, "shanghai"));

    }

    @Test
    public void testJson2Object() throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue("{\"id\":1,\"name\":\"wangzhiping\",\"age\":27,\"address\":\"shanghai\"}", User.class);
        System.out.println(user);
    }
}
