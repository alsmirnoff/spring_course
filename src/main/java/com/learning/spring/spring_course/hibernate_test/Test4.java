package com.learning.spring.spring_course.hibernate_test;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_test.entity.Employee;

public class Test4 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .buildSessionFactory();

        try(Session session = factory.openSession()){
            session.beginTransaction();
            
            // Employee emp = session.find(Employee.class, 1);
            // emp.setSalary(1500);

            session.createMutationQuery("update Employee set salary = 1000 where firstName = 'Aleksandr'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        }       

    }
}
