package lesson2;
// задание к уроку №2 Синеокая Марина
public class Main {
    public static void main(String[] args) {
        //задаем и заполняем 3 тестовых массива
        String[][] array4x4 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] errorArray = {{"1","5","6","4"},{"1","3","3","4"},{"1","2","4","4"},{"1","2","3"}};
        String[][] errorData = {{"1","1","3","4",},{"1","2","аа3","4"},{"1","2","аа3","4"},{"1","2","аа3","4"}};
        //подаем массивы на вход метода
        System.out.println("Случай корректного массива:");
        checkPrint(array4x4);
        System.out.println("Случай некорректного массива:");
        checkPrint(errorArray);
        System.out.println("Случай некорректных данных:");
        checkPrint(errorData);
    }

    //печать результатов
    public static void checkPrint(String[][] a)
    {
        int result = 0;
        try {
            result = 0;
            result = checkExceptions(a);
        } catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Результат суммирования элементов массива равен: "+String.valueOf(result));
            System.out.println();
        }
    }
    //проверка Exceptions и расчет суммы
    public static int checkExceptions(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int summa = 0;
        int value = 0;
        int row = 0;
        int col = 0;
        //некорректный размер
        if(a.length != 4 || a[0].length != 4 || a[1].length != 4 || a[2].length != 4 || a[3].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < a.length; i++) {
            row = i;
            for (int j = 0; j < a[row].length; j++) {
                col = j;
                try {
                    value = Integer.parseInt(a[i][j]);
                    summa = summa+ value;
                } catch (IllegalArgumentException e) {
                    //приводим к корректным номерам адрес ячейки
                    int rowErr=Integer.parseInt(String.valueOf(row))+1;
                    int colErr=Integer.parseInt(String.valueOf(col))+1;
                    String message = "в " + rowErr + " ряду, " + colErr + " столбце";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return summa;
    }
}