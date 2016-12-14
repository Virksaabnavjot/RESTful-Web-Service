package com.example.room304.listviewexample;

/**
 * Created by dominiccarr on 21/11/2016.
 */
public class Student {

    private int age;
    private String name;
    private String biography;
    private String[] subjects;

    public Student(String name, int age, String biography, String[] subjects){
        this.name = name;
        this.age = age;
        this.biography= biography;
        this.subjects = subjects;
    }

    public static Student[] getStudents(){
        Student a = new Student("Dominic Carr", 28, "I am dominic", new String[] {"Server Side Web Technologies", "Android", "Lecturing", "Web Services"} );
        Student b = new Student("Paul S", 28, "I am a student in NCI, I love NCI", new String[] {"Math", "Java", "Python", "PHP", "C#"} );
        Student c = new Student("Donald Trump", 70, "Believe me!", new String[] {"Walls", "ISIS"} );

        return new Student[] {a,b,c};
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        subjects = subjects;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
