package com.learning.spring.spring_course.hibernate_one_to_one ;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_one_to_one.entity.Detail;
import com.learning.spring.spring_course.hibernate_one_to_one.entity.Employee;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .addAnnotatedClass(Detail.class)
                            .buildSessionFactory();

        try(Session session = factory.getCurrentSession();){
            // Employee employee = new Employee("Nikolay", "Hibernatov", "HR", 850);
            // Detail detail = new Detail("California", "698745128", "nik@gmail.com");
            
            // employee.setEmpDetail(detail);
            // detail.setEmployee(employee);

            // session.beginTransaction();
            // session.persist(detail);
            // session.getTransaction().commit();

            // System.out.println("Done!");


            // session.beginTransaction();
            // Detail detail = session.find(Detail.class, 4);
            // System.out.println(detail.getEmployee());            
            // session.getTransaction().commit();

            // System.out.println("Done!");

            session.beginTransaction();

            Detail detail = session.find(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.remove(detail);

            session.getTransaction().commit();

            System.out.println("Done!");
        }   

        factory.close();
    }
}
