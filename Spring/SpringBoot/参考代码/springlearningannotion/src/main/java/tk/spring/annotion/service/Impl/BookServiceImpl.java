package tk.spring.annotion.service.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.spring.annotion.dao.BookDao;
import tk.spring.annotion.model.Person;
import tk.spring.annotion.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    //通过BookDaoImpl上面添加@Primary，当有多个条件符合的注入时，有限选择BookDaoImpl
    @Autowired
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void readBook(Person person) {
        logger.info(person.getName() + " is reading book "+bookDao.getBook());
    }
}
