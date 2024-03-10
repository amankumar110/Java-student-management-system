package in.amankumar.studentapp.utils;

public class Generator {

    private static Integer idCounter = 1;

    public static Integer generateId() {

        idCounter++;
        return idCounter;
    }
}
