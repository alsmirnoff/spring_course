package com.learning.spring.spring_course.hibernate_one_to_many_uni ;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_one_to_many_uni.entity.Department;
import com.learning.spring.spring_course.hibernate_one_to_many_uni.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .addAnnotatedClass(Department.class)
                            .buildSessionFactory();

        try(Session session = factory.getCurrentSession();){
            // Department dep = new Department("HR", 1500, 500);
            // Employee emp1 = new Employee("Oleg", "Ivanov", 800);
            // Employee emp2 = new Employee("Andrey", "Sidorov", 1000);

            // dep.addEmployeeToDepartment(emp1);
            // dep.addEmployeeToDepartment(emp2);

            // session.beginTransaction();
            // session.persist(dep);
            // session.getTransaction().commit();

            // System.out.println("Done!");

            // session.beginTransaction();
            // Department department = session.find(Department.class, 2);
            // System.out.println(department);
            // System.out.println(department.getEmps());
            // session.getTransaction().commit();

            // System.out.println("Done!");

            // session.beginTransaction();
            // Employee employee = session.find(Employee.class, 1);
            // System.out.println(employee);
            // System.out.println(employee.getDepartment());
            // session.getTransaction().commit();

            // System.out.println("Done!");
            //*******************************************************
            session.beginTransaction();
            Department department = session.find(Department.class, 4);
            session.remove(department);
            session.getTransaction().commit();

            System.out.println("Done!");
        }   

        factory.close();
    }
}
