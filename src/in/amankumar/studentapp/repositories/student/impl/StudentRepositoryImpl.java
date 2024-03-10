package in.amankumar.studentapp.repositories.student.impl;

import in.amankumar.studentapp.models.Student;
import in.amankumar.studentapp.repositories.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {
    
    private final List<Student> students;


    public StudentRepositoryImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public Student addStudent(Student student) {

        this.students.add(student);
        return student;
    }

    @Override
    public List<Student>  findAllStudents() {

        return students;
    }

    @Override
    public Student findStudentById(Integer id) {

        if(students != null && !students.isEmpty()) {
            for(Student student : students) {
                if(Objects.equals(student.getId(), id)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Student findStudentByName(String name) {

        if(students != null && !students.isEmpty()) {
            for(Student student : students) {
                if(student.getName().equals(name)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student) {

        for (int i = 0; i < students.size(); i++) {

            Student foundStudent = students.get(i);
            if (Objects.equals(foundStudent.getId(), student.getId())) {
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    @Override
    public Student deleteStudent(Student student) {

        this.students.remove(student);
        return student;
    }
}
