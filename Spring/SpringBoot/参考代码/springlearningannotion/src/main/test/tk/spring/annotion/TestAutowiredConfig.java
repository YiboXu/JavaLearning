package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.AutowiredConfig;
import tk.spring.annotion.controller.BookController;
import tk.spring.annotion.controller.BookController2;

public class TestAutowiredConfig extends Base {
    public TestAutowiredConfig() {
        super(AutowiredConfig.class);
    }

    @Test
    public void test(){
        BookController bookController = (BookController) this.getBeanById("bookController");
        bookController.invokeService();

        BookController2 bookController2 = (BookController2) this.getBeanById("bookController2");
        bookController2.invokeService();

    }
}
