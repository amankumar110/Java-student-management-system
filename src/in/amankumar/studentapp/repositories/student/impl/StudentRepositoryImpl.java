package in.amankumar.studentapp.repositories.student.impl;

import in.amankumar.studentapp.models.Student;
import in.amankumar.studentapp.repositories.student.StudentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {


    private final File file = new File("students.ser");

    public StudentRepositoryImpl() {


    }


    @Override
    public Student addStudent(Student student) throws IOException, ClassNotFoundException {

        List<Student> students = this.findAllStudents();

        if(students == null)
            students = new ArrayList<>();

        students.add(student);
        this.saveStudentsToFile(students);

        return student;
    }

    @Override
    public List<Student> findAllStudents() throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();

        if(file.length()==0) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    students.add(student);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
        }

        return students;
    }

    @Override
    public Student findStudentById(Integer id) throws IOException, ClassNotFoundException {


        List<Student> students = this.findAllStudents();

        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
                if (Objects.equals(student.getId(), id)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Student findStudentByName(String name) throws IOException, ClassNotFoundException {

        List<Student> students = this.findAllStudents();

        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student) throws IOException, ClassNotFoundException {

        List<Student> students = this.findAllStudents();

        Student updatedStudent = null;

        for (int i = 0; i < students.size(); i++) {

            Student foundStudent = students.get(i);
            if (Objects.equals(foundStudent.getId(), student.getId())) {
                updatedStudent = students.set(i, student);
                break;
            }
        }

        this.saveStudentsToFile(students);

        return updatedStudent;
    }

    @Override
    public Student deleteStudent(Student student) throws IOException, ClassNotFoundException {

        List<Student> students = this.findAllStudents();


        for(int i=0; i<students.size(); i++) {

            Student foundStudent = students.get(0);

            if(foundStudent.getId().equals(student.getId())) {
                students.remove(i);
                break;
            }

        }

        this.saveStudentsToFile(students);
        return student;
    }

    private Student saveStudentsToFile(List<Student> students) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            if(students.isEmpty()) {
                return null;
            }else
                for (Student s : students) {
                    oos.writeObject(s);
                }
        }

        return students.get(0);
    }
}
