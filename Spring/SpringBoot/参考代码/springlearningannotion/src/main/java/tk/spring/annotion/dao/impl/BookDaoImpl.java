package tk.spring.annotion.dao.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tk.spring.annotion.dao.BookDao;
import tk.spring.annotion.model.Book;

@Primary
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public Book getBook() {
        Book book = new Book();
        book.setName("Spring Learning");
        book.setPrice(100);

        return book;
    }
}
