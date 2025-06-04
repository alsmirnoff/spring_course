package com.learning.spring.spring_course.hibernate_one_to_many_bi ;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learning.spring.spring_course.hibernate_one_to_many_bi.entity.Department;
import com.learning.spring.spring_course.hibernate_one_to_many_bi.entity.Employee;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Employee.class)
                            .addAnnotatedClass(Department.class)
                            .buildSessionFactory();

        try(Session session = factory.getCurrentSession();){
            // Department dep = new Department("Sales", 1500, 800);
            // Employee emp1 = new Employee("User", "Testov", 800);
            // Employee emp2 = new Employee("Test", "Userov", 1500);
            // Employee emp3 = new Employee("Anton", "Antonov", 1200);

            // dep.addEmployeeToDepartment(emp1);
            // dep.addEmployeeToDepartment(emp2);
            // dep.addEmployeeToDepartment(emp3);

            // session.beginTransaction();
            // session.persist(dep);
            // session.getTransaction().commit();

            // System.out.println("Done!");

            //*******************************************************

            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.find(Department.class, 5);

            System.out.println("Show department"); 
            System.out.println(department);

            System.out.println("Load our employees");
            department.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department"); 
            System.out.println(department.getEmps());

            System.out.println("Done!");

            //*******************************************************

            // session.beginTransaction();
            // Employee employee = session.find(Employee.class, 1);
            // System.out.println(employee);
            // System.out.println(employee.getDepartment());
            // session.getTransaction().commit();

            // System.out.println("Done!");

            //*******************************************************

            // session.beginTransaction();
            // Employee employee = session.find(Employee.class, 4);
            // session.remove(employee);
            // session.getTransaction().commit();

            // System.out.println("Done!");
        }   

        factory.close();
    }
}
