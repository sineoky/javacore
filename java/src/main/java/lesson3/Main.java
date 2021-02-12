package lesson3;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int index1, index2; //элементы массива, которые меняем местами
        index1 = 1;
        index2 = 3;
        System.out.println("Задание 1");
        System.out.println("Меняем местами элементы " + (index1 + 1) + " и " + (index2 + 1));
        //Integer
        MyArray<Integer> array1 = new MyArray<Integer>(1, 2, 3, 4, 5);
        System.out.println("Исходный массив Integer");
        array1.printMyArray();
        array1.changeMyArray(1, 3);
        System.out.println();
        System.out.println("Отсортированный массив Integer");
        array1.printMyArray();
        System.out.println();
        //Double
        MyArray<Double> array2 = new MyArray<Double>(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("Исходный массив Double");
        array2.printMyArray();
        array2.changeMyArray(1, 3);
        System.out.println();
        System.out.println("Отсортированный массив Double");
        array2.printMyArray();
        System.out.println();
        //String
        MyArray<String> array3 = new MyArray<String>("1", "2", "3", "4", "5");
        System.out.println("Исходный массив String");
        array3.printMyArray();
        array3.changeMyArray(1, 3);
        System.out.println();
        System.out.println("Отсортированный массив String");
        array3.printMyArray();
        System.out.println();
        //Object
        MyArray<Object> array4 = new MyArray<Object>(1, "2", 3.0, "4", 5);
        System.out.println("Исходный массив Object");
        array4.printMyArray();
        array4.changeMyArray(1, 3);
        System.out.println();
        System.out.println("Отсортированный массив Object");
        array4.printMyArray();
        System.out.println();
        System.out.println();
        System.out.println("Задание 2");
        //создаем коробку с яблоками;
        Box<Apple> apples = new Box<>();
        //складываем в коробку яблоки
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        //создаем коробку с апельсинами;
        Box<Orange> oranges = new Box<>();
        ////складываем в коробку апельсины
        oranges.addFruit(new Orange());
        oranges.addFruit(new Orange());
        System.out.println("Вес коробки с яблоками " + apples.getWeight()); //печать веса коробки с яблоками
        System.out.println("Вес коробки с апельсинами " + oranges.getWeight()); //печать веса коробки с апельсинами
        //сравниваем коробки
        if (apples.compare(oranges)) {
            System.out.println("Массы коробок одинаковые");
        } else {
            System.out.println("Массы коробок разные");
        }
        //новые коробки
        Box<Orange> newOranges = new Box<>(); //другая коробка для апельсинов
        Box<Apple> newApples = new Box<>(); //другая коробка для яблок
        oranges.changeFruitBoxes(newOranges);
        System.out.println("Апельсины пересыпаны");
        System.out.println("Вес старой коробки с апельсинами " + oranges.getWeight());
        System.out.println("Вес новой коробки с апельсинами " + newOranges.getWeight());
        apples.changeFruitBoxes(newApples);
        System.out.println("Яблоки пересыпаны");
        System.out.println("Вес старой коробки с яблоками " + apples.getWeight());
        System.out.println("Вес новой коробки с яблоками " + newApples.getWeight());
    }
    }




