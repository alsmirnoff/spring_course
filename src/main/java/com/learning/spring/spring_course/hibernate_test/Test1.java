package com.learning.spring.spring_course.hibernate_test;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_test.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .buildSessionFactory();
        try(Session session = factory.getCurrentSession();){
            Employee emp = new Employee("Aleksandr", "Testov", "IT", 600);
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(emp);
        }       

    }
}
