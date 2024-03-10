package in.amankumar.studentapp.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable{

    private Integer id;
    private String name;
    private String age;
    private String grade;
    private LocalDate DOB;

    public Student(String name, String age, String grade, LocalDate DOB) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.DOB = DOB;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
