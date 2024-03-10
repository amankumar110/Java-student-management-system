package in.amankumar.studentapp.repositories.student;

import in.amankumar.studentapp.models.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface StudentRepository {

    Student addStudent(Student student) throws IOException, ClassNotFoundException;

    List<Student> findAllStudents() throws IOException, ClassNotFoundException;

    Student findStudentById(Integer id) throws IOException, ClassNotFoundException;

    Student findStudentByName(String name) throws IOException, ClassNotFoundException;

    Student updateStudent(Student student) throws IOException, ClassNotFoundException;

    Student deleteStudent(Student student) throws IOException, ClassNotFoundException;
}
