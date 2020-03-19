package tk.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLog {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void testLog(){
        logger.trace("这是trace记录");
        logger.debug("这是debug记录");
        logger.info("这是info记录");
        logger.warn("这是warn记录");
        logger.error("这是error记录");
    }
}
