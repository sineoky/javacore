package lesson5;

public class AppData {
    private String[] header;
    private int[][] data;


    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    //печать класса данных
    public void print() {
        System.out.println("Класс данных:");
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            int row = i;
            for (int j = 0; j < data[row].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void save (AppData data)
        {

        }
    }
