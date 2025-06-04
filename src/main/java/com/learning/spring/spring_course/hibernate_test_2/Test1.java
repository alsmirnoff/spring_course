package com.learning.spring.spring_course.hibernate_test_2 ;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_test_2.entity.Detail;
import com.learning.spring.spring_course.hibernate_test_2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .addAnnotatedClass(Detail.class)
                            .buildSessionFactory();

        // try(Session session = factory.getCurrentSession();){

        //     Employee employee = new Employee("User", "Testov", "IT", 500);
        //     Detail detail = new Detail("Test_city", "123456789", "test@gmail.com");
        //     employee.setEmpDetail(detail);
            
        //     session.beginTransaction();
        //     session.persist(employee);
        //     session.getTransaction().commit();

        //     System.out.println("Done!");
        // }

        try(Session session = factory.getCurrentSession();){
            
            session.beginTransaction();
            Employee emp = session.find(Employee.class, 2);
            session.remove(emp);
            session.getTransaction().commit();

            System.out.println("Done!");
        }   

        factory.close();
    }
}
