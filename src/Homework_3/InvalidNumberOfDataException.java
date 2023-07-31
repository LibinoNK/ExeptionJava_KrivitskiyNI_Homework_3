package Homework_3;

public class InvalidNumberOfDataException extends ArrayIndexOutOfBoundsException{
    public InvalidNumberOfDataException() {
        super("Данные введены некорректно!");
    }
}

