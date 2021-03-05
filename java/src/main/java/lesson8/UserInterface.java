package lesson8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private final Controller controller=new Controller();

    public void runApplication(){
        Scanner scanner=new Scanner(System.in);
        while (true) {
        System.out.println("Введите название города на английском языке");
        String city= scanner.nextLine();
        //получаем id города
            //try { AccuWeatherProvider.setGlobalCity(city);}
        //catch (IOException e) {
          //  e.printStackTrace();}
        System.out.println("Введите ответ: 1 - Получить погоду на следующие 5 дней, "+"0 - завершить работу");
        String result=scanner.nextLine();
        Integer result2 = Integer.valueOf(result);
            if(result2==1) {
                try {
                    AccuWeatherProvider.getWeather(Periods.IN5DAYS, city);
                } catch (IOException e) {
                    e.printStackTrace();
                }break;
            }
        else {break;}
        }
        }
    }

