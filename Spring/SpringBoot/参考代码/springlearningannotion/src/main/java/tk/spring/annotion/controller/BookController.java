package tk.spring.annotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.Person;
import tk.spring.annotion.service.BookService;

import javax.annotation.Resource;

public class BookController {
    @Autowired
    private BookService bookService;

    //通过@Qualifier来指定获取beanId="sofica"的组件注入
    @Qualifier("sofica")
    @Autowired
    private Person person;

    //@Resource()
    private Color color;

    public BookController() {
        System.out.println("BookController non-parm constructor is invoked");
    }

    @Autowired
    public BookController(BookService bookService, Person person, Color color) {
        System.out.println("BookController constructor is invoked");
        this.bookService = bookService;
        this.person = person;
        this.color = color;
    }

    @Autowired
    public void setColor(Color color) {
        System.out.println("Spring 调用 setColor 方法: "+color);
        this.color = color;
    }

    @Autowired
    public void fun1(Color color) {
        System.out.println("Spring 调用 fun1 方法: "+color);
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void invokeService(){
        bookService.readBook(person);
    }
}
