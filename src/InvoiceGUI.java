import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceGUI {
    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel itemPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    private void setMainFrame(){
        mainFrame.setTitle("Invoice");
        mainFrame.setSize(600, 1200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void setMainPanel(){
        JTextArea currentInvoice = new JTextArea(11, 50);
        currentInvoice.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        currentInvoice.setEditable(false);

        currentInvoice.append("==================================================\n");
        currentInvoice.append("                      INVOICE                     \n");
        currentInvoice.append("--------------------------------------------------\n");
        currentInvoice.append("ITEM                       QTY    PRICE    TOTAL  \n");
        currentInvoice.append("Apple                      ___    $0.65    _______\n");
        currentInvoice.append("Juice                      ___    $5.51    _______\n");
        currentInvoice.append("Cupcake                    ___    $2.25    _______\n");
        currentInvoice.append("Strawberries               ___    $2.05    _______\n");
        currentInvoice.append("--------------------------------------------------\n");
        currentInvoice.append("AMOUNT DUE:                            ___________\n");
        currentInvoice.append("==================================================\n");

        // _0_ _00 000
        // $0.00__ $00.00_ $000.00
        // $0.00______ $00.00_____ $000.00____ $0000.00___ $00000.00__ $000000.00_ $0000000.00
    }

    private void setItemPanel(){
        JComboBox item = new JComboBox(new String[]{"Apple", "Juice", "Cupcake", "Strawberries"});
    }

    private void setButtons(){
        JButton add = new JButton();
        JButton total = new JButton();
        JButton quit = new JButton();

        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(add);
        buttonPanel.add(total);
        buttonPanel.add(quit);
    }

    public void updateMainFrame(){
        updatePanels();
        mainFrame.show();

        // mainFrame.invalidate();
        // mainFrame.validate();
        // mainFrame.repaint();
    }

    private void updatePanels(){
        // update invoice
        // update item
        // update button
    }
}
