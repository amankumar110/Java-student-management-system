package in.amankumar.studentapp;

import in.amankumar.studentapp.dtos.StudentDTO;
import in.amankumar.studentapp.exceptions.InvalidStudentDetailException;
import in.amankumar.studentapp.exceptions.StudentNotFoundException;
import in.amankumar.studentapp.models.Student;
import in.amankumar.studentapp.repositories.student.StudentRepository;
import in.amankumar.studentapp.repositories.student.impl.StudentRepositoryImpl;
import in.amankumar.studentapp.services.student.StudentService;
import in.amankumar.studentapp.services.student.impl.StudentServiceImpl;
import in.amankumar.studentapp.utils.Validator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String choice;

        StudentRepository studentRepository = new StudentRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl(studentRepository);

        System.out.println("Welcome to the Student Management System");

        while(true) {

            System.out.println("Enter 1 - Add Student");
            System.out.println("Enter 2 - Find All Students");
            System.out.println("Enter 3 - Find Student by Name");
            System.out.println("Enter 4 - Update Student");
            System.out.println("Enter 5 - Delete Student");
            System.out.println("Enter 6 - Exit");

            System.out.println("Enter your Choice: ");
            choice = scanner.nextLine();

            switch(choice) {

                case "1":

                    StudentDTO studentDTO = new StudentDTO();

                    System.out.println("Enter the name of student: ");
                    studentDTO.setName(scanner.nextLine());

                    System.out.println("Enter the grade of student: ");
                    studentDTO.setGrade(scanner.nextLine());

                    System.out.println("Enter the age of student: ");
                    studentDTO.setAge(scanner.nextLine());

                    System.out.println("Enter the date of birth of student in (DD-MM-YYYY) format: ");
                   studentDTO.setDOB(scanner.nextLine());


                   Student student = studentService.addStudent(studentDTO);
                   if(student!=null)
                       System.out.println(studentDTO.getName()+" was Successfully Added!");
                    break;

                case "2":

                    List<Student> students = studentService.findAllStudents();

                    if(students==null || students.isEmpty())
                        System.out.println("Students not Available!!!");
                     else
                        students.forEach(System.out::println);
                    break;

                case "3":

                    System.out.println("Enter the name of student: ");
                    String name2 = scanner.nextLine();

                    if(!Validator.isName(name2)) {
                        System.out.println(name2 + " is a wrong name");
                        break;
                    }

                    Student foundStudent = studentService.findStudentByName(name2);

                    if(foundStudent!=null)
                        System.out.println(foundStudent);
                    else
                        System.out.println("No Student Found with Name: "+name2);

                    break;

                case "4":

                    System.out.println("Enter the Id of the Student: ");
                    Integer updateId = null;

                    try {
                        updateId = Integer.valueOf(scanner.nextLine());
                    } catch(NumberFormatException e) {
                        System.out.println("Invalid ID was Provided: "+updateId);
                        break;
                    }

                    StudentDTO updateStudentDTO = new StudentDTO();

                    System.out.println("Enter the name of student: ");
                    updateStudentDTO.setName(scanner.nextLine());

                    System.out.println("Enter the grade of student: ");
                    updateStudentDTO.setGrade(scanner.nextLine());

                    System.out.println("Enter the age of student: ");
                    updateStudentDTO.setAge(scanner.nextLine());

                    System.out.println("Enter the date of birth of student in (DD-MM-YYYY) format: ");
                    updateStudentDTO.setDOB(scanner.nextLine());

                    Student updatedStudent = studentService.updateStudent(updateId,updateStudentDTO);

                    if(updatedStudent!=null)
                        System.out.println(updateStudentDTO.getName()+" was updated");
                    break;
                case "5":
                    System.out.println("Enter the Id of the Student: ");
                    Integer deleteId = null;

                    try {
                        deleteId = Integer.parseInt(scanner.nextLine());
                        Student deletedStudent = studentService.deleteStudent(deleteId);
                        if (deletedStudent != null) {
                            System.out.println("Student with ID(" + deletedStudent.getId() + ") Deleted Successfully");
                        } else {
                            System.out.println("Student with ID(" + deleteId + ") Not Found");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID was Provided: " + deleteId);
                    }
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
