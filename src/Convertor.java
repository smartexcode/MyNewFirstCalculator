import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// прочитать про конструктор

public class Convertor {

    // этот класс конвертирует Римский массив[со значением] в Арабские цифры
    static Map<String, Integer> romainArabic = new HashMap<>();
    static TreeMap<Integer, String> arabicRomain = new TreeMap<>();

    Convertor() {
        romainArabic.put("I", 1);
        romainArabic.put("II", 2);
        romainArabic.put("III", 3);
        romainArabic.put("IV", 4);
        romainArabic.put("V", 5);
        romainArabic.put("VI", 6);
        romainArabic.put("VII", 7);
        romainArabic.put("VIII", 8);
        romainArabic.put("IX", 9);
        romainArabic.put("X", 10);

        arabicRomain.put(1, "I");
        arabicRomain.put(4, "IV");
        arabicRomain.put(5, "V");
        arabicRomain.put(9, "IX");
        arabicRomain.put(10, "X");
        arabicRomain.put(40, "XL");
        arabicRomain.put(50, "L");
        arabicRomain.put(90, "XC");
        arabicRomain.put(100, "C");

    }

    // метод который возвращает true или false проверяя Римские ли символы
    static boolean proverka (String roms) {
        return romainArabic.containsKey(roms);
    }


    // Метод который возвращает мне Арабские
    static Integer returnArabian(String keyR) {
        Integer valueA = romainArabic.get(keyR);
        return valueA;
    }

    // Метод который возвращает мне Римские конкатенируя с TreeMap
    static String returnRomain(Integer keyA) {
        StringBuilder resul = new StringBuilder("");
        int keyArab; // меньшее или раное к keyA(ключу мапы Арабского )

        do {
            keyArab = arabicRomain.floorKey(keyA);
            resul.append(arabicRomain.get(keyArab));
            keyA = keyA - keyArab;

        } while (keyA != 0);

        return String.valueOf(resul);

    }
}
