import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введи пример на +-* или / из двух арабских или двух римских цифр от 1 до 10");
        String expression = scaner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int elem1;
        int elem2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-/*]");
        if (operands.length != 2) throw new Exception("Должно быть два числа и одно арифметическое дейтвие!");
        oper = detectOperation(expression);


        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            elem1 = Roman.convertToArabian(operands[0]);
            elem2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            elem1 = Integer.parseInt(operands[0]);
            elem2 = Integer.parseInt(operands[1]);
            isRoman = false;
        } else {
            throw new Exception("Не верный диапазон римских чисел или не верный формат римского числа!!!");
        }

        if ((elem1 > 10) || (elem2 > 10)) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        if ((elem1 <1) || (elem2 <1)) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calculator(elem1, elem2, oper);

        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть >0");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;


    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calculator(int a, int b, String oper) {
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }
}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 1; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}