package exception;

/**
 * Created by Artem Guretski
 */
public class IncorrectCountryNameException extends Exception {
    public IncorrectCountryNameException() {
        super("Incorrect country name");
    }
}
