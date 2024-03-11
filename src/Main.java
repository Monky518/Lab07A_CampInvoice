import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean validInput = false;
        boolean done = false;
        Scanner scan = new Scanner(System.in);
        double totalPrice = 0.0;
        ArrayList<String> totalItems = new ArrayList<String>();

        // ask user for address
        // ask user for items, quantity, and price
        //      q for quit
        //      a for add
        //      d for done / grand total

        String userAddress = SafeInput.getNonZeroLenString(scan, "What is the address?");
        do {
            String userInput = SafeInput.getRegExString(scan, "Would you like to add items, get total, or quit? [A T Q]", "[AaTtQq]");
            if (userInput.equalsIgnoreCase("A")){
                String itemName = SafeInput.getNonZeroLenString(scan, "What is the item name?");
                double itemPrice = SafeInput.getRangedDouble(scan, "What is the item price?", 0, 999);
                int itemQuantity = SafeInput.getRangedInt(scan, "How many items are being bought?", 1, 99);

                double itemTotal = itemPrice * itemQuantity;
                totalPrice += itemTotal;
                totalItems.add(String.format("%-28s %2d $%7.2f $%7.2f", itemName, itemQuantity, itemPrice, itemTotal));
            }
            else if (userInput.equalsIgnoreCase("T")){

                System.out.println("==================================================");
                System.out.println("                     INVOICE                      ");
                System.out.println(userAddress);
                System.out.println("--------------------------------------------------");
                System.out.printf("%-27s %3s %5s %8s \n", "ITEM", "QTY", "PRICE", "TOTAL");
                for (String item : totalItems){
                    System.out.println(item);
                }
                System.out.println("--------------------------------------------------");
                System.out.printf("AMOUNT DUE:                              $%7.2f\n", totalPrice);
                System.out.println("==================================================");
                done = true;
            }
            else{
                boolean confirm = SafeInput.getYNConfirm(scan, "Are you sure you want to quit?");
                if(confirm) {
                    done = true;
                }
            }
        } while (!done);
    }
}