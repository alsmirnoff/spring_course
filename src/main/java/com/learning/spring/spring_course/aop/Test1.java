package com.learning.spring.spring_course.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        
        uniLibrary.getBook();
        uniLibrary.addBook("User1", book);
        uniLibrary.addMagazine();
        
        // uniLibrary.returnMagazine();
        // uniLibrary.addBook();

        // uniLibrary.returnBook();
        
        // SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        // schoolLibrary.getBook();

        context.close();
    }
}
