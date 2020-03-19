package tk.springboot.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

/**
 * 通过@Value向ValueInject的属性注入值,这个值可以是常量值，也可以是配置文件的定义的值(通过SpEL表达式获取)
 */
@Component
public class ValueInject {
    @Value("${person.name}")
    private String name;
    @Value("20")
    private int age;

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
        return "Value{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
