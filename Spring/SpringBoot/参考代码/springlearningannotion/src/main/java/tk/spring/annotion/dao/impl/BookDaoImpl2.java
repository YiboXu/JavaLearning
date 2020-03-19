package tk.spring.annotion.dao.impl;

import org.springframework.stereotype.Repository;
import tk.spring.annotion.dao.BookDao;
import tk.spring.annotion.model.Book;

@Repository
public class BookDaoImpl2 implements BookDao {
    @Override
    public Book getBook() {
        Book book = new Book();
        book.setName("Big Data Learning");
        book.setPrice(200);

        return book;
    }
}
