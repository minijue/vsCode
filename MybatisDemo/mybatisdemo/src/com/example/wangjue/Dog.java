package com.example.wangjue;

public class Dog {
    private Integer id;
    private String name;
    private Integer age;
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Dog { name = " + name + ", age = " + age + " }";
    }
}
