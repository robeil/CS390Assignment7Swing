package CS390Assignment7Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringUtility extends JFrame {

    private JFrame frame;
    private JTextField textInput;
    private JTextField textOutput;
    private String userInput;
    private int count;

    public StringUtility() {
        initialize(); }

    //another method
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("String Utility");
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{186, 15, 6, 31, 159, 0};
        gridBagLayout.rowHeights = new int[]{23, 0, 0, 0, 0, 20, 0, 23, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);
        JLabel labelInput = new JLabel("Input");
        GridBagConstraints gbc_labelInput = new GridBagConstraints();
        gbc_labelInput.anchor = GridBagConstraints.WEST;
        gbc_labelInput.insets = new Insets(0, 0, 5, 0);
        gbc_labelInput.gridwidth = 2;
        gbc_labelInput.gridx = 4;
        gbc_labelInput.gridy = 0;
        frame.getContentPane().add(labelInput, gbc_labelInput);
        JButton btnCount = new JButton("Count Letters");
        //colling the count button with the event handler
        btnCount.addActionListener(new CountEventHandler());
        GridBagConstraints gbc_btnCount = new GridBagConstraints();
        gbc_btnCount.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnCount.insets = new Insets(0, 0, 5, 5);
        gbc_btnCount.gridx = 0;
        gbc_btnCount.gridy = 1;
        frame.getContentPane().add(btnCount, gbc_btnCount);
        textInput = new JTextField();
        GridBagConstraints gbc_textInput = new GridBagConstraints();
        gbc_textInput.insets = new Insets(0, 0, 5, 5);
        gbc_textInput.fill = GridBagConstraints.HORIZONTAL;
        gbc_textInput.gridx = 4;
        gbc_textInput.gridy = 1;
        frame.getContentPane().add(textInput, gbc_textInput);
        textInput.setColumns(10);
        JButton btnReverse = new JButton("Reverse Letters");
        //calling the button with the event handler
        btnReverse.addActionListener(new ReverseEventHandler());
        GridBagConstraints gbc_btnReverse = new GridBagConstraints();
        gbc_btnReverse.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnReverse.insets = new Insets(0, 0, 5, 5);
        gbc_btnReverse.gridwidth = 2;
        gbc_btnReverse.gridx = 0;
        gbc_btnReverse.gridy = 2;
        frame.getContentPane().add(btnReverse, gbc_btnReverse);
        JLabel labelOutput = new JLabel("Output");
        GridBagConstraints gbc_labelOutput = new GridBagConstraints();
        gbc_labelOutput.insets = new Insets(0, 0, 5, 5);
        gbc_labelOutput.anchor = GridBagConstraints.WEST;
        gbc_labelOutput.gridx = 4;
        gbc_labelOutput.gridy = 2;
        frame.getContentPane().add(labelOutput, gbc_labelOutput);
        JButton btnRemove = new JButton("Remove Duplicates");
        //calling and apply the remove button
        btnRemove.addActionListener(new RemoveEventHandler());
        GridBagConstraints gbc_btnRemove = new GridBagConstraints();
        gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
        gbc_btnRemove.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnRemove.gridwidth = 4;
        gbc_btnRemove.gridx = 0;
        gbc_btnRemove.gridy = 3;
        frame.getContentPane().add(btnRemove, gbc_btnRemove);
        textOutput = new JTextField();
        GridBagConstraints gbc_textOutput = new GridBagConstraints();
        gbc_textOutput.insets = new Insets(0, 0, 5, 5);
        gbc_textOutput.fill = GridBagConstraints.HORIZONTAL;
        gbc_textOutput.gridx = 4;
        gbc_textOutput.gridy = 3;
        frame.getContentPane().add(textOutput, gbc_textOutput);
        textOutput.setColumns(10);
    }
    //count letters event handler
    class CountEventHandler implements ActionListener {
        @Override
    public void actionPerformed(ActionEvent e) {
        //getting the user input from user input textField
        userInput = textInput.getText();
        count = 0;
        //counting the text given
        for(int i = 0; i < userInput.length(); i++) {
            count++;
        }
        //converting the number to String
        String outPut = String.format("%d", count);
        textOutput.setText(outPut);
    }
    }
    //reverse letters event handler
    class ReverseEventHandler implements ActionListener{ @Override
    public void actionPerformed(ActionEvent e) {
        //getting the user input from the text field
        userInput = textInput.getText();
        //reversing the given word
        String rev = new StringBuffer(userInput).reverse().toString();
        textOutput.setText(rev);
    }
    }
    //Remove duplicates letters handler
    class RemoveEventHandler implements ActionListener{ @Override
    public void actionPerformed(ActionEvent e) {
        //getting the user input
        userInput = textInput.getText();
        char[] chars = userInput.toCharArray();
        Set<Character> charSet = new LinkedHashSet<Character>();
        //adding the character to set
        for(char c: chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        //adding the non-duplicated character in a string
        for(Character ch: charSet) {
            sb.append(ch);
        }
        //setting the text
        textOutput.setText(sb.toString());
    }
    }
    //main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StringUtility window = new StringUtility();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




}
