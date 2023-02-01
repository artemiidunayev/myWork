import java.util.Scanner;
public class Calculator {
    static String romeNumber[] = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI","XXII","XXIII",
            "XXIV", "XXV","XXVI", "XXVII", "XXVIII","XXIX", "XXX","XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "66", "67", "68", "69", "LXX", "71", "LXXII", "73", "74", "75",
            "76", "77", "78", "79", "LXXX", "LXXXI", "82", "83", "84", "85", "86", "87", "88", "89", "90",
            "91", "92", "93", "94", "95", "96", "97", "98", "99", "C"};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

String expression = scanner.nextLine();
String [] splittingString = expression.split(" ");
if (splittingString.length > 3){
    throw new Exception("Invalid expression");
}
if (splittingString.length == 1){
    throw new Exception("Invalid expression!");
}
        String num1 = splittingString [0];
        String op = splittingString [1];
        String num2 = splittingString [2];


        boolean arabOrRoman = false;
        for (String x : romeNumber){
            if (x.equals(num1.toString())){
                arabOrRoman = true;
                break;
            }
        }
        boolean romanOrArab = false;
        for (String x : romeNumber){
            if (x.equals(num2.toString())){
                romanOrArab = true;
                break;
            }
        }
        if ((arabOrRoman==true&&romanOrArab==false)||(arabOrRoman==false&&romanOrArab==true)){
            throw new Exception("Different number system");
        }
               boolean isRome = true;
        int number1 = getArabNumber(num1);
        if (number1 == -1) {
            isRome = false;
            number1 = Integer.valueOf(num1);
        }
        int number2 = getArabNumber(num2);
        if (number2 == -1) {
            number2 = Integer.valueOf(num2);
        }

        if (number1 > 10 || number2 > 10) {
            throw new Exception("¬веденые числа больше 10");
        }

        int answer = 0;

        switch (op) {
            case "+":
                answer = number1 + number2;
                break;
            case "-":
                answer = number1 - number2;
                break;
            case "*":
                answer = number1 * number2;
                break;
            case "/":
                answer = number1 / number2;
                break;
            default:
                break;
        }
        if ((arabOrRoman == true && romanOrArab == true && answer == 0) || (arabOrRoman == true && romanOrArab == true && answer < 0)){
            throw new Exception("There a no 0 and negative numbers in the Roman system");
        }
        if (isRome == true) {
            System.out.println(getRomeNumber(answer));
        } else {
            System.out.println(answer);
        }


    }

    public static int getArabNumber(String num) {
        for (int i = 0; i < romeNumber.length; i++) {
            if (romeNumber[i].equals(num)) {
                return i;
            }
        }
        return -1;
    }

    public static String getRomeNumber(int num) {
        for (int i = 0; i < romeNumber.length; i++) {
            if (i == num) {
                return romeNumber[i];
            }
        }
        return null;
    }
}