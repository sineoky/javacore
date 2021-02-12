package lesson3;
import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> box = new ArrayList();

    public Box(T... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    //добавляем фрукт в коробку
    public void addFruit(T fruit) {
        box.add(fruit);
    }

    //подсчет веса коробки
    public double getWeight() {
        float weight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            weight = weight + box.get(i).getWeight();
        }
        return weight;
    }

    //метод сравнения текущий коробки с той, которую подадут в compare() в качестве параметра
    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001f;
    }

    //пересыпка из текущей коробки в другую
    public void changeFruitBoxes(Box<T> newBox) {
        newBox.box.addAll(this.box);
        this.box.clear();
    }
}