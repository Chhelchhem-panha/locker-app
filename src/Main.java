import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static String password = null;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lock Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        JPanel inputPanel = new JPanel(new FlowLayout());

        JTextField inputField = new JPasswordField(10);
        JButton enterButton = new JButton("Enter");
        JButton clearButton = new JButton("Clear");
        JLabel statusLabel = new JLabel("Enter Password");

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> inputField.setText(inputField.getText() + button.getText()));
            gridPanel.add(button);
        }

        clearButton.addActionListener(e -> inputField.setText(""));

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password == null) {
                    password = inputField.getText();
                    statusLabel.setText("Password Set");
                } else {
                    if (password.equals(inputField.getText())) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }
                inputField.setText("");
            }
        });

        inputPanel.add(clearButton);
        inputPanel.add(inputField);
        inputPanel.add(enterButton);

        panel.add(gridPanel, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);
        panel.add(statusLabel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}