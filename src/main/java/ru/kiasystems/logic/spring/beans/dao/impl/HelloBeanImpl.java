package ru.kiasystems.logic.spring.beans.dao.impl;

import ru.kiasystems.logic.spring.beans.dao.HelloBean;

public class HelloBeanImpl implements HelloBean {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }
}
