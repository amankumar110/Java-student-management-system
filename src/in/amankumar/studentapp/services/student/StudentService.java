package in.amankumar.studentapp.services.student;


import in.amankumar.studentapp.dtos.StudentDTO;
import in.amankumar.studentapp.models.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDTO studentDTO);

    List<Student> findAllStudents();

    Student findStudentByName(String name);

    Student updateStudent(Integer id, StudentDTO studentDTO);

    Student deleteStudent(Integer id);
}
