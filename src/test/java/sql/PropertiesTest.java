package sql;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author EDZ
 * @description
 * @date 2020/7/27 10:33
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Person person = new Person("tom", 12);
        
    }
}

@AllArgsConstructor
@ToString
class Person implements Serializable {
    private String name;
    private int age;
}

class NewPerson implements Serializable{
    private int name;
    private int age;
}