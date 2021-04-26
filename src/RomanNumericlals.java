public class RomanNumericlals {
    public static String format(int value) {
        String romanNum = "";
        while (value > 0) {
            while (value >= 1000) {
                romanNum = romanNum + "M";
                value -= 1000;
            }
            while (value >= 900) {
                romanNum = romanNum + "CM";
                value -= 900;
            }
            while (value >= 500) {
                romanNum = romanNum + "D";
                value -= 500;
            }
            while (value >= 400) {
                romanNum = romanNum + "CD";
                value -= 400;
            }
            while (value >= 100) {
                romanNum = romanNum + "C";
                value -= 100;
            }
            while (value >= 90) {
                romanNum = romanNum + "XC";
                value -= 90;
            }
            while (value >= 50) {
                romanNum = romanNum + "L";
                value -= 50;
            }
            while (value >= 40) {
                romanNum = romanNum + "XL";
                value -= 40;
            }
            while (value >= 10) {
                romanNum = romanNum + "X";
                value -= 10;
            }
            while (value >= 9) {
                romanNum = romanNum + "IX";
                value -= 9;
            }
            while (value >= 5) {
                romanNum = romanNum + "V";
                value -= 5;
            }
            while (value >= 4) {
                romanNum = romanNum + "IV";
                value -= 4;
            }
            while (value >= 1) {
                romanNum = romanNum + "I";
                value -= 1;
            }

        }
        return romanNum;
    }
}
