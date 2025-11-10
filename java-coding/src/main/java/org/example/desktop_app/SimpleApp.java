package org.example.desktop_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleApp {
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("My Simple Java App");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create components
        JLabel label = new JLabel("Click the button!");
        JButton button = new JButton("Click Me");

        // Add action when button is clicked
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello, World! You clicked the button!");
            }
        });

        // Add components to frame
        frame.add(label);
        frame.add(button);

        // Make frame visible
        frame.setVisible(true);
    }
}
