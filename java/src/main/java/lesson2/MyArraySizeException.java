package lesson2;
//неверный размер массива
public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Подается массив некорректного размера");
    }
}
