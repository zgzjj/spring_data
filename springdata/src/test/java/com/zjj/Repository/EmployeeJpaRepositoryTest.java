package com.zjj.Repository;

import com.zjj.domain.Employee;
import com.zjj.repository.EmployeeJpaRepository;
import com.zjj.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository=null;
    @Before
    public void setup(){
        ctx=new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository=ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){
       Employee employee = employeeJpaRepository.findOne(99);
       System.out.println("employee:"+employee);
       System.out.println("employee(10):"+employeeJpaRepository.exists(10));
       System.out.println("employee(102):"+employeeJpaRepository.exists(102));
    }
}
