package com.chepseskaf.server;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author chepseskaf
 */
@XmlRootElement
public class MyJaxbBean {
    public String name;
    public int age;

    public MyJaxbBean() {} // JAXB needs this

    public MyJaxbBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}