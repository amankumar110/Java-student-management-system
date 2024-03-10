package in.amankumar.studentapp.services.student;


import in.amankumar.studentapp.dtos.StudentDTO;
import in.amankumar.studentapp.models.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    Student addStudent(StudentDTO studentDTO) throws IOException, ClassNotFoundException;

    List<Student> findAllStudents() throws IOException, ClassNotFoundException;

    Student findStudentByName(String name) throws IOException, ClassNotFoundException;

    Student updateStudent(Integer id, StudentDTO studentDTO) throws IOException, ClassNotFoundException;

    Student deleteStudent(Integer id) throws IOException, ClassNotFoundException;
}
