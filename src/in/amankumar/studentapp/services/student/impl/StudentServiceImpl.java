package in.amankumar.studentapp.services.student.impl;

import in.amankumar.studentapp.dtos.StudentDTO;
import in.amankumar.studentapp.models.Student;
import in.amankumar.studentapp.repositories.student.StudentRepository;
import in.amankumar.studentapp.services.student.StudentService;
import in.amankumar.studentapp.utils.Generator;
import in.amankumar.studentapp.utils.Validator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(StudentDTO studentDTO) throws IOException, ClassNotFoundException {

        if(!isStudentValid(studentDTO)) {
            return null;
        }

        Student student = mapToModel(studentDTO);
        student.setId(Generator.generateId());
        student.setDOB(LocalDate.parse(studentDTO.getDOB(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return this.studentRepository.addStudent(student);
    }

    @Override
    public List<Student> findAllStudents() throws IOException, ClassNotFoundException {

        return this.studentRepository.findAllStudents();
    }

    @Override
    public Student findStudentByName(String name) throws IOException, ClassNotFoundException {

        return this.studentRepository.findStudentByName(name);
    }

    @Override
    public Student updateStudent(Integer id, StudentDTO studentDTO) throws IOException, ClassNotFoundException {

        Student foundStudent = this.studentRepository.findStudentById(id);
        if (foundStudent == null) {
            System.out.println("Student not found with Id: "+id);
            return null;
        }

        if(!isStudentValid(studentDTO))
            return null;

        foundStudent.setName(studentDTO.getName());
        foundStudent.setGrade(studentDTO.getGrade());
        foundStudent.setAge(studentDTO.getAge());
        foundStudent.setDOB(LocalDate.parse(studentDTO.getDOB(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return this.studentRepository.updateStudent(foundStudent);
    }

    @Override
    public Student deleteStudent(Integer id) throws IOException, ClassNotFoundException {

        Student foundStudent = this.studentRepository.findStudentById(id);

        if (foundStudent == null) {
            System.out.println("Student not found with Id: "+id);
            return null;
        }

        return this.studentRepository.deleteStudent(foundStudent);
    }

    private boolean isStudentValid(StudentDTO studentDTO) {

        if (!Validator.isName(studentDTO.getName())) {
            System.out.println("Wrong Name was Provided: " + studentDTO.getName());
            return false;
        } else if (!Validator.isGrade(studentDTO.getGrade())) {
            System.out.println("Wrong Grade was Provided: " + studentDTO.getGrade());
            return false;
        } else if (!Validator.isAge(studentDTO.getAge())) {
            System.out.println("Wrong Age was Provided: " + studentDTO.getAge());
            return false;
        } else if (!Validator.isDOB(studentDTO.getDOB())) {
            System.out.println("Wrong DOB was Provided: " + studentDTO.getDOB());
            return false;
        }

        return true;
    }

    private Student mapToModel(StudentDTO studentDTO) {

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setGrade(studentDTO.getGrade());
        student.setAge(studentDTO.getAge());

        return student;
    }

    private StudentDTO mapToDto(Student student) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setGrade(student.getGrade());
        studentDTO.setAge(student.getAge());
        studentDTO.setDOB(student.getDOB().toString());

        return studentDTO;
    }
}
