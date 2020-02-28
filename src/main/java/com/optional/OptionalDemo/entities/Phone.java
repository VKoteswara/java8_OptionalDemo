package com.optional.OptionalDemo.entities;

import java.io.Serializable;

public class Phone implements Serializable {
    Integer no;

    public Phone() {
        super();
    }

    public Phone(Integer no) {
        super();
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "no=" + no +
                '}';
    }
}
