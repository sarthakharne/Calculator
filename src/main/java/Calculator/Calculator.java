package Calculator;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Calculator {
    private static Logger logger;
    public Calculator() {
        logger  = LogManager.getLogger(Calculator.class);
    }
    public static void menu(){
        System.out.println("Scientific Calculator");
        System.out.println("**************************");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Logarithm");
        System.out.println("4. Power");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String [] arg){
        Calculator cal = new Calculator();

        Scanner sc = new Scanner(System.in);
//        sc.nextLine();

        int choice;

        do {
            Calculator.menu();

            choice = sc.nextInt();

            double num1, num2, ans;

            switch(choice) {
                case 1:
                    System.out.print("Enter Number: ");
                    num1 = sc.nextDouble();
                    ans = cal.mySqrt(num1);
                    if(ans == -1) {
                        System.out.println("Invalid Input");
                    }
                    else {
                        System.out.println("Square root of " + num1 + " is " + ans);
                    }
                    break;

                case 2:
                    System.out.print("Enter Number: ");
                    num1 = sc.nextDouble();
                    ans = cal.myFactorial(num1);
                    if(ans == -1) {
                        System.out.println("Invalid Input");
                    }
                    else {
                        System.out.println("Factorial of " + num1 + " is " + ans);
                    }
                    break;

                case 3:
                    System.out.print("Enter Number: ");
                    num1 = sc.nextDouble();
                    ans = cal.myLog(num1);
                    if(ans == -1) {
                        System.out.println("Invalid Input");
                    }
                    else {
                        System.out.println("Natural logarithm (base е) of " + num1 + " is " + ans);
                    }
                    break;

                case 4:
                    System.out.print("Enter First Number: ");
                    num1 = sc.nextDouble();

                    System.out.print("Enter Second Number: ");
                    num2 = sc.nextDouble();

                    ans = cal.myPow(num1, num2);
                    System.out.println("Power of " + num1 + " to " + num2 + " is " + ans);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
            System.out.println();
        }
        while (choice != 0);
        sc.close();
    }
    public double mySqrt(double num) {
        if(num < 0) {
            logger.error("[SQUARE_ROOT] - " + num + " - [RESULT] - " + "null");
            return -1;
        }

        double ans = Math.sqrt(num);

        logger.info("[SQUARE_ROOT] - " + num + " - [RESULT] - " + ans);
        return ans;
    }

    public double myFactorial(double num) {
        if(num < 0) {
            logger.error("[FACTORIAL] - " + num + " - [RESULT] - " + "null");
            return -1;
        }

        double ans = 1;
        for(int i = 1; i <= num; i++) {
            ans *= i;
        }

        logger.info("[FACTORIAL] - " + num + " - [RESULT] - " + ans);

        return ans;
    }

    public double myLog(double num) {
        if(num <= 0) {
            logger.error("[LOGARITHM] - " + num + " - [RESULT] - " + "null");
            return -1;
        }

        double ans = Math.log(num);
        logger.info("[LOGARITHM] - " + num + " - [RESULT] - " + ans);
        return ans;
    }

    public double myPow(double num1, double num2) {
        double ans = Math.pow(num1, num2);
        logger.info("[POWER] - " + num1 + " " + num2 + " - [RESULT] - " + ans);
        return ans;
    }
}