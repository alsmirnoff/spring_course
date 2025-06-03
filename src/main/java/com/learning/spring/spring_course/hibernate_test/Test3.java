package com.learning.spring.spring_course.hibernate_test;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_test.entity.Employee;

public class Test3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .buildSessionFactory();

        try(Session session = factory.openSession()){
            session.beginTransaction();
            
            // List<Employee> emps = session.createQuery("from Employee", Employee.class).getResultList();
            
            List<Employee> emps = session.createQuery("from Employee where surname = 'Testov' AND salary > 1000", Employee.class).getResultList();

            for (Employee e : emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        }       

    }
}
