package wed.tipcalculator;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class WedTipCalculator {
    
    public static final String SERVER_NAME_QUESTION 
            = "What was the name of your server? ";
    public static final String BILL_AMOUNT_QUESTION 
            = "How much was your bill? ";
    public static final String SERVICE_QUALITY_QUESTION
            = "How was your service? ";
    
    public static final double SALES_TAX = 0.08;
    
    public static final double BAD_SERVICE_TIP = 0.1;
    public static final double GOOD_SERVICE_TIP = 0.25;
    public static final double GREAT_SERVICE_TIP = 0.3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double billAmount;
        String serverName;
        String serviceQuality;
        double tipAmount;
        double taxAmount;
        double finalBillAmount;
        
        System.out.print(SERVER_NAME_QUESTION);
        serverName = input.nextLine();
        
        System.out.println();
        System.out.print(BILL_AMOUNT_QUESTION);
        billAmount = input.nextDouble();
        
        // input.nextDouble leaves the \n char. We need to discard that before
        // getting more user input.
        input.nextLine();
        
        System.out.println();
        System.out.print(SERVICE_QUALITY_QUESTION);
        serviceQuality = input.nextLine();
        
        taxAmount = billAmount * SALES_TAX;
        
        if (serviceQuality.equalsIgnoreCase("bad")) {
            tipAmount = (billAmount + taxAmount) * BAD_SERVICE_TIP;
        } else if (serviceQuality.equalsIgnoreCase("good")) {
            tipAmount = (billAmount + taxAmount) * GOOD_SERVICE_TIP;
        } else {
            tipAmount = (billAmount + taxAmount) * GREAT_SERVICE_TIP;
        }
        
        finalBillAmount = billAmount + taxAmount + tipAmount;
        
//        System.out.println(
//                "Your server " 
//                + serverName 
//                + " gave " 
//                + serviceQuality
//                + " service and receives a tip of "
//                + tipAmount
//                + " bringing the final bill to "
//                + finalBillAmount
//        );

        System.out.printf(
                "Your server %s gave %s service and receives "
                + "a tip of $%.2f bringing the final bill to $%.2f\n",
                serverName,
                serviceQuality,
                tipAmount,
                finalBillAmount
        );
    }
    
}
