import java.util.Scanner;

public class Calculator {

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative number not allowed");
        long result = 1;
        for (int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
//this is for testing1
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Scientific Calculator ---");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (!x)");
            System.out.println("3. Natural Log (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = sc.nextDouble();
                    if(num<0)
                    {
                        System.out.println("Invalid input ");
                        break;
                    }
                    System.out.println("Result: " + Math.sqrt(num));
                    break;

                case 2:
                    System.out.print("Enter integer: ");
                    int factNum = sc.nextInt();
                    System.out.println("Result: " + factorial(factNum));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double logNum = sc.nextDouble();
                    if(logNum<=0)
                    {
                        System.out.println("Invalid input ");
                        break;
                    }
                    System.out.println("Result: " + Math.log(logNum));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = sc.nextDouble();
                    if(exp<0 && base==0)
                    {
                        System.out.println("Not defined.");
                        break;
                    }
                    System.out.println("Result: " + Math.pow(base, exp));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
