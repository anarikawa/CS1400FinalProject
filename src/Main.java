import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean inputVar = true;
        double totalSale = 0.0;
        double totalTip = 0.0;
        double totalAmount = 0.0;
        int checkCount = 0;

        // total amount of sales and tips calculated
        while (inputVar) {
            System.out.println("\nCheck #" + (checkCount + 1));

            System.out.print("Subtotal: ");
            double saleAmount = scnr.nextDouble();
            totalSale += saleAmount;

            System.out.print("Tip: ");
            double tipAmount = scnr.nextDouble();
            totalTip += tipAmount;

            totalAmount = saleAmount + tipAmount;
            System.out.printf("Total Paid: %.2f\n" , totalAmount);

            checkCount++;
            System.out.printf("Total sale so far: %.2f\n" , totalSale);
            System.out.printf("Total pooled tip so far: %.2f\n" , totalTip);

            System.out.print("Do you want to stop (y/n): ");
            char testingInput = scnr.next().charAt(0);
            if (testingInput == 'y' || testingInput == 'Y') {
                inputVar = false;
            }
        }
        System.out.printf("\nThe total sale amount is: %.2f\n" , totalSale);
        System.out.printf("The total pooled tip amount is: %.2f\n" , totalTip );
        System.out.printf("The total amount: %.2f\n" , (totalSale + totalTip));
        distributeTips(totalTip);

        scnr.close(); // Close the scanner to avoid resource leak.
    }

    public static void distributeTips(double totalTip) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nTip Distributions: " );

        //60% goes to the servers
        //ask user how many servers were there that day
        System.out.println("How many servers were at work today?");
        int numServers = scnr.nextInt();
        System.out.printf("Server (each): $%.2f\n", totalTip * .6 / numServers);

        //5% to the busser
        System.out.printf("Busser: $%.2f\n", totalTip * .05);

        //10% to the host
        System.out.printf("Host: $%.2f\n", totalTip * .1);

        //25% to the kitchen
        //40% of that to the chef and sous-chef
        System.out.printf("Chef: $%.2f\n", totalTip * .25 * .4);
        System.out.printf("Sous-chef: $%.2f\n", totalTip * .25 * .4);
        //20% of that to the kitchen aid
        System.out.printf("Kitchen Aid: $%.2f\n", totalTip * .25 * .2);
        scnr.close();
    }
}

