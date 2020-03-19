package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.mybatis.mapper.CountryMapper;

@SpringBootTest
public class TestCountry {
    @Autowired
    private CountryMapper countryMapper;
    @Test
    void testSelectAllCountry(){
        countryMapper.selectAll().stream().forEach(System.out::println);
    }
}
