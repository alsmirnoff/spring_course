package com.learning.spring.spring_course.hibernate_test;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_test.entity.Employee;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .buildSessionFactory();

        try(Session session1 = factory.openSession();
            Session session2 = factory.openSession()){
            Employee emp = new Employee("Oleg", "Sidorov", "HR", 700);
            session1.beginTransaction();
            session1.persist(emp);
            //session1.getTransaction().commit();

            int myId = emp.getId();
            // session2.beginTransaction();
            Employee employee = session1.find(Employee.class, myId);
            session1.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done!");
        }       

    }
}
