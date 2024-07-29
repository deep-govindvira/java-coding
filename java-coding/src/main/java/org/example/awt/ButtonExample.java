package org.example.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class ButtonExample {
    public static void main (String[] args) {

        Frame frame = new Frame("Frame");

        Label label = new Label("0");
        label.setBounds(50, 50, 100, 20);

        TextField textField = new TextField("TextField");
        textField.setBounds(50, 100, 100, 20);

        final var button = getButton(label, frame);

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static Button getButton(Label label, Frame frame) {
        Button button = new Button("Button");
        button.addActionListener(e -> {
            if(label.getText().equals("Red")) {
                label.setText("Green");
                frame.setBackground(new Color(0, 255, 0));
            }
            else if(label.getText().equals("Green")) {
                label.setText("Blue");
                frame.setBackground(new Color(0, 0, 255));
            }
            else {
                label.setText("Red");
                frame.setBackground(new Color(255, 0, 0));
            }
        });
        button.setBounds(50, 150, 50, 20);
        return button;
    }
}
