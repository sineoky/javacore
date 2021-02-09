package lesson2;
public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("В массив заведены некорректные данные "+message);
    }
}