package com.company;

public class Person {
    private String name;
    private int height = -1;
    private int weight = -1;
    private int age = -1;

    // Default constructor
    Person()
    {
        this.name = "None";
    }

    // constructor
    Person(String name, int height, int weight, int age)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    void Grow(int x)
    {
        this.height += x;
    }

    void GetFat()
    {
        this.weight *= 2;
    }


    public String ToString()
    {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Name:" + name);
        stringBuffer.append(" height(in):" + height);
        stringBuffer.append(" weight(lb):" + weight);
        stringBuffer.append(" age(yr): " + age);
        return stringBuffer.toString();
    }

}
