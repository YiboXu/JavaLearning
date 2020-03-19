package tk.spring.annotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.Person;
import tk.spring.annotion.service.BookService;

import javax.annotation.Resource;

@Controller("bookController2")
public class BookController2 {
    private BookService bookService;

    private Person person;

    private Color color;

    public BookController2(BookService bookService, Person person, Color color) {
        System.out.println("BookController2 constructor2 is invoked");
        this.bookService = bookService;
        this.person = person;
        this.color = color;
    }

    public void invokeService(){
        bookService.readBook(person);
    }
}
