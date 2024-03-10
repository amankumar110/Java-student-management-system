package in.amankumar.studentapp.repositories.student;

import in.amankumar.studentapp.models.Student;

import java.util.List;

public interface StudentRepository {

    Student addStudent(Student student);

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    Student findStudentByName(String name);

    Student updateStudent(Student student);

    Student deleteStudent(Student student);
}
