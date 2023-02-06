import java.io.EOFException;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception, IOException, IndexOutOfBoundsException {

        // Объявляем объект класса Римских цифр чтобы с ним работать здесь
        Convertor convertor = new Convertor();
        Object returnArabian;

        // ввод в консоль
        Scanner input = new Scanner(System.in);

        System.out.print("Напишите значения через пробел! Арабские либо Римские от 1 до 10 не более, " +
                "используйте 2 операнда и один оператор (+, -, /, *) \nВведите: ");
        String num = input.nextLine();

        // преобразовали в Массив каждую строку через пробел
        String[] numbers = num.split(" ");

        try {
            String a = numbers[0];
            String b = numbers[1];
            String c = numbers[2];





            int a1, c1;

            // проверяем если римские то далее это используем
                boolean rimskiyeLi = Convertor.proverka(a);

                if (rimskiyeLi) {// if (true) если Римские то
                    a1 = Convertor.returnArabian(a);
                    c1 = Convertor.returnArabian(c);

                    if (a1 < 1 || a1 > 10) {
                        throw new NumberFormatException();
                    } else if (c1 < 1 || c1 > 10) {
                        throw new NumberFormatException();
                    }

                } else { //if (false) если Арабские то
                    a1 = Integer.parseInt(a);
                    c1 = Integer.parseInt(c);

                    if (a1 < 1 || a1 > 10) {
                        throw new NumberFormatException();
                    } else if (c1 < 1 || c1 > 10) {
                        throw new NumberFormatException();
                    }

                }

            if (Convertor.proverka(a) == Convertor.proverka(c)) {} else { throw new Exception();}

                int result = 0;
                switch (b) { // тут перебираем для String b значения и исходя какой сивол такое и решение
                    case "+":
                        result = a1 + c1;
                        break;
                    case "-":
                        result = a1 - c1;
                        break;
                    case "/":
                        result = a1 / c1;
                        break;
                    case "*":
                        result = a1 * c1;
                        break;
                    default:
                        System.out.println("Ошибка! пиши такие (+,-,*,/) знаки для арифмитических операций");
                        break;
                }


                if (rimskiyeLi) {
                    Integer x = result;
                    if (x < 1) throw new IOException();
                }

                if (rimskiyeLi) {
                    System.out.println("Результат: " + Convertor.returnRomain(result));
                } else {
                    System.out.println("Результат: " + result);
                }

        } catch (ArrayIndexOutOfBoundsException ex1) {
            System.out.println("Ошибка! т.к строка не является математической операцией");
        } catch (IOException ex2){
            System.out.println("Ошибка! т.к. в римской системе нет отрицательных чисел");
        } catch (NumberFormatException ex3) {
            System.out.println("Ошибка! т.к вы не ввели числа от 1 до 10");
        } catch (Exception ex4){
            System.out.println("Ошибка! т.к. используются одновременно разные системы счисления ");
        }
    }
}
