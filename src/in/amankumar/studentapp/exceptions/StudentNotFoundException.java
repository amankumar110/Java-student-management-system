package in.amankumar.studentapp.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
