package com.learning.spring.spring_course.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Грокаем алгоритмы")
    private String name;

    public String getName() {
        return name;
    }
}
