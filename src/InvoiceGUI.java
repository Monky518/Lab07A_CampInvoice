import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceGUI {
    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
        JTextArea currentInvoice = new JTextArea(5, 50);
    JPanel buttonPanel = new JPanel();
    JPanel addPanel = new JPanel();
        JTextArea itemName = new JTextArea(1, 50);
        JTextArea itemPrice = new JTextArea(1, 10);
        SpinnerModel itemQty = new SpinnerNumberModel(1, 1, 99, 1);
            JSpinner spinner = new JSpinner(itemQty);
    JPanel addButtonPanel = new JPanel();

    private void setMainFrame(){
        mainFrame.setTitle("Invoice");
        mainFrame.setSize(600, 1200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void setMainPanel(){
        currentInvoice.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        currentInvoice.setEditable(false);

        currentInvoice.append("==================================================\n");
        currentInvoice.append("                      INVOICE                     \n");
        currentInvoice.append("--------------------------------------------------\n");
        currentInvoice.append("ITEM                       QTY    PRICE    TOTAL  \n");
        currentInvoice.append("--------------------------------------------------\n");
        currentInvoice.append("'Amount due' formatted string\n");
        currentInvoice.append("==================================================\n");

        mainPanel.add(currentInvoice);
    }

    public void updateMainPanel(ArrayList<Item> items){
        currentInvoice.setRows(5 + items.size());
        currentInvoice.setColumns(50);

        // clear before adding text
        currentInvoice.setText("");
        currentInvoice.append("==================================================\n");
        currentInvoice.append("                      INVOICE                     \n");
        currentInvoice.append("--------------------------------------------------\n");
        for (Item item : items){
            currentInvoice.append("Whatever info " + item.getName() + "has\n");
        }
        currentInvoice.append("ITEM                       QTY    PRICE    TOTAL  \n");
        currentInvoice.append("--------------------------------------------------\n");
        currentInvoice.append("'Amount due' formatted string\n");
        currentInvoice.append("==================================================\n");

        // refreshes everything
        currentInvoice.setVisible(false);
        mainPanel.setVisible(false);
        mainPanel.setVisible(true);
        currentInvoice.setVisible(true);
    }

    private void setButtons(){
        JButton add = new JButton("ADD");
        JButton total = new JButton("TOTAL");
        JButton quit = new JButton("QUIT");

        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(add);
        buttonPanel.add(total);
        buttonPanel.add(quit);
    }

    private void setAddPanel(){
        // JTextArea itemName = new JTextArea(1, 50);
        // JTextArea itemPrice = new JTextArea(1, 10);
        // SpinnerModel itemQty = new SpinnerNumberModel(1, 1, 99, 1);
        //      JSpinner spinner = new JSpinner(itemQty);

        JTextArea title = new JTextArea();
        title.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        currentInvoice.setEditable(false);
        title.setText("ADD");

        itemName.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        itemName.setText("Enter item name here");

        itemPrice.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        itemPrice.setText("Enter item price here [$0.00]");


    }
}
