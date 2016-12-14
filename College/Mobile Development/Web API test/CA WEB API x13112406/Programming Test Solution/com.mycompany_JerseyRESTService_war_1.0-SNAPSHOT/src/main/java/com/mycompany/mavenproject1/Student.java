package com.mycompany.mavenproject1;

import java.util.Date;
import java.util.List;
import java.util.Map;

class Student {

    private final Integer id;
    private final String name;
    private final Integer age;
    private final String college;
    private final Date birthday;
    private final List<String> subjects;
    
    public Student(Integer id, String name, Integer age, String college, Date birthday, List<String> subjects){
         this.id = id;
         this.name = name;
         this.age = age;
         this.college = college;
         this.birthday = birthday;
         this.subjects = subjects;
    }

    Integer getID() {
        return id;
    }
    
    String getName() {
        return name;
    }
}
