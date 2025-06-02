package com.learning.spring.spring_course.aop.aspects;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.learning.spring.spring_course.aop.Student;

@Component
@Aspect
public class UniversityLoggingAspect {

    // @Before("execution(* getStudents())")
    // public void beforeGetStudentsLoggingAdvice(){
    //     System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents");
    // }

    // @AfterReturning(pointcut = "execution(* getStudents())",
    //             returning = "students")
    // public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
    //     Student firtsStudent = students.get(0);

    //     String nameSurname = firtsStudent.getNameSurname();
    //     nameSurname = "Mr. " + nameSurname;
    //     firtsStudent.setNameSurname(nameSurname);

    //     Double avgGrade = firtsStudent.getAvgGrade();
    //     avgGrade = avgGrade + 1;
    //     firtsStudent.setAvgGrade(avgGrade);

    //     System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после выполнения метода getStudents");
    // }

    // @AfterThrowing(pointcut = "execution(* getStudents())",
    //             throwing = "exception")
    // public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
    //     System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения " + exception);
    // }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы метода или выброс исключения");
    }
}
