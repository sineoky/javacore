package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phone = new HashMap<>();

    //печать справочника
    public void print() {
        System.out.println("Телефонный справочник:");
        System.out.println(phone);
    }

    //добавление записей
    public void add(String name, String phoneNum) {
        //добавляем новую запись
        ArrayList<String> phoneList = phone.get(name);
        if (phoneList == null) { //такого имени нет
            //новая запись
            phoneList = new ArrayList<>();
        }
        phoneList.add(phoneNum);
        phone.put(name, phoneList);
    }

    //ищем номер телефона по фамилии
    public ArrayList<String> get(String name) {
        return phone.get(name);
    }

}

