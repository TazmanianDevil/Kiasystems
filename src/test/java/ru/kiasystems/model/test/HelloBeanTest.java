package ru.kiasystems.model.test;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kiasystems.logic.spring.beans.dao.HelloBean;

public class HelloBeanTest {

    @Test
    public void testHelloBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring/datasource-tx-jpa.xml");
        context.getBean(HelloBean.class).sayHello();
    }
}
