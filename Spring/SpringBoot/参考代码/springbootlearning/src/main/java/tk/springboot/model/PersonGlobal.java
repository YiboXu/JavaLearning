package tk.springboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties(prefix = "person") 将全局配置文件(application.yml, application.properties)中person映射到类Person
 * 只有这个类加入到spring容器才会使映射生效，所以需要加上@Component
 *
 * 通过在pom.xml中添加下面的依赖，可以在编辑application.yaml的时候自动提示
 *
 * <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-configuration-processor</artifactId>
 *      <optional>true</optional>
 * </dependency>
 */

@Component
@ConfigurationProperties(prefix = "person")
//开启校验
@Validated
public class PersonGlobal {
    //name必须是邮箱格式，所以当从配置文件中注入值的时候，如果name不是邮箱格式，注入会失败
    @Email
    private String name;
    @NumberFormat
    private int age;
    private boolean boss;
    private Date birth;
    private Map<String,String> maps;
    private List<String> list;
    private Dog dog;

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

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
