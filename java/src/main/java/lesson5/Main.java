package lesson5;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //заполняем класс для хранения исходных данных
        //заголовок
        String[] header={"Value1","Value2","Value3"};
        //данные
        int[][] data ={{100,200,123},{300,400,500}};
        AppData h = new AppData(header, data);
        //класс для хранения импортируемых из файла данных
        int[][] data2 = new int[2][3];
        String[] header2=new String[3];
        String[] token1, token2; //временные массивы для хранения данных из файлов

        //1.Сохраняем данные в csv файл
        File file = new File("./appdata_to_file.csv");
        if(!file.exists()) {
            file.createNewFile();
            }
        else {
            System.out.println("Файл \"appdata_to_file.csv\" существует");
        }
        //записываем в CSV
        try (PrintWriter out = new PrintWriter("appdata_to_file.csv")) {
            //заголовки
            for (int i = 0; i < header.length-1; i++) {
                out.print(header[i] + ";");
            }
                out.print(header[header.length-1]);
                out.println();
            //данные
            for (int i = 0; i < data.length; i++) {
               int row = i;
               for (int j = 0; j < data[row].length-1; j++) {
                  out.print(data[i][j] + ";");
                }
                out.print(data[i][data[row].length-1]);
                out.println();
            }
            System.out.println("Файл \"appdata_to_file.csv\" успешно заполнен из класса AppData.");
            } catch(IOException e){
                e.printStackTrace();
            }
        //2. выводим данные из файла
        try (BufferedReader in=new BufferedReader(new FileReader("appdata_to_file.csv"))){
            String result2;
            String result=null;
            result2=in.readLine();
            //заполняем заголовок в классе
            token1=result2.split( ";");
            for (int i = 0; i < token1.length; i++) {
                header2[i]=token1[i];
            }
            System.out.println();
            //заполняем данные в классе
            result=in.readLine();
            token2=result.split(";");
            //первая строка данных
            for (int i = 0; i < token2.length; i++) {
                data2[0][i]=Integer.parseInt(token2[i]);}
            int k=0;
            //остальные данные
            while ((result = in.readLine())!=null) {
                k=k+1;
                token2=result.split(";");
                for (int i = 0; i < token2.length; i++) {
                    data2[k][i]= Integer.parseInt(token2[i]);
            }
        }
        }
            catch(IOException e){
            e.printStackTrace();
            }
        //создание объекта класса AppData с загруженными данными из файла
        AppData h2 = new AppData(header2, data2);
        h2.print(); //печать
    }
             }



