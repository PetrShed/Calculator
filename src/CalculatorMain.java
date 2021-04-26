import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CalculatorMain {
    public static void main(String[] args) throws IOException {
        String f1, s2;
        int first_num = 0;
        int second_num = 0;
        int result = 0;

        System.out.println("Введите операцию которую необходимо вычислить в формате a + b, a - b, a * b, " +
                "a / b.\nОбе переменные должны быть представлены либо одновременно арабскими цифрами, либо одновременно " +
                "римскими цифрами.\nВводные числа должны быть от 1 до 10 включительно. Результат вычисления римских цифр" +
                " не должен быть отрицательным.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        char[] arabs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < line.length(); i++) {
            char k = line.charAt(i);
            if ((k == '-') || (k == '+') || (k == '/') || (k == '*')) {
                f1 = line.substring(0, i).trim();
                s2 = line.substring(i + 1).trim();

                if (checkArab(arabs, f1) && checkArab(arabs, s2)) {
                    try {
                        first_num = Integer.parseInt(f1);
                    } catch (NumberFormatException e) {
                        br.close();
                        System.err.println("Неверный формат строки!");
                        break;
                    }
                    try {
                        second_num = Integer.parseInt(s2);
                    } catch (NumberFormatException e) {
                        br.close();
                        System.err.println("Неверный формат строки!");
                    }
                    if ((first_num < 1) || (first_num >10) || (second_num < 1) || (second_num >10)) {
                        br.close();
                        System.out.println("Число должно быть от 1 до 10 включительно!");
                    } else {
                        result = calculate(k, first_num, second_num);
                        System.out.println(result);
                    }
                } else if (checkRoman(romans, f1, s2)) {
                    first_num = RomanToArab.valueOf(f1).getTranslation();
                    second_num = RomanToArab.valueOf(s2).getTranslation();
                    result = calculate(k,first_num,second_num);
                    String romanResult = RomanNumericlals.format(result);
                    if (result > 0) {
                        System.out.println(romanResult);
                    } else
                    {
                        br.close();
                        System.out.println("Результат вычисления римских цифр не может быть меньше 0!");
                    }
                } else {
                    br.close();
                    System.out.println("Неверный формат строки!");
                }
                break;
            }
        }

    }

    private static boolean checkRoman(String[] romans, String s, String ss) {
        for (String roman : romans) {
            if (roman.equals(s)) {
                for (String roman2 : romans) {
                    if (roman2.equals(ss)) {
                        return true;
                    } else continue;
                }
            } else continue;
        }
        return false;
    }

    private static boolean checkArab(char[] arabs, String s) {
        boolean result = false;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            char x = s.charAt(j);
            for (char arab : arabs) {
                if (arab == x) {
                    result = true;
                    count++;
                    break;
                }
                result = false;
            }
        }
        if (count < s.length()) {
            result = false;
        }
        return result;
    }
        private static  int calculate(char x, int num1, int num2) {
        int result = 0;
            switch (x) {
                case '+' -> result = Operations.sum(num1, num2);
                case '-' -> result = Operations.sub(num1, num2);
                case '*' -> result = Operations.mul(num1, num2);
                case '/' -> result = Operations.div(num1, num2);
            }
            return result;
        }
    }
