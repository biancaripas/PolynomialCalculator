package org.example;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window  extends JFrame{

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textFieldA;
    private JTextField textFieldS;
    private JTextField textFieldD;
    private JTextField textFieldM;
    private JTextField textFieldI;


    public Window() {
        this.setSize(500, 500);
        getContentPane().setLayout(null);

        JLabel lblNewLabel1 = new JLabel("Calculator de polinoame");
        lblNewLabel1.setBounds(150, 30, 207, 29);
        getContentPane().add(lblNewLabel1);
        lblNewLabel1.setForeground(Color.RED);

        JLabel lblNewLabel = new JLabel("Polynomial 1");
        lblNewLabel.setBounds(29, 90, 117, 29);
        lblNewLabel.setForeground(Color.RED);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(16, 120, 130, 26);
        getContentPane().add(textField);
        textField.setColumns(10);
        textField.setForeground(Color.RED);

        JLabel lblNewLabel_1 = new JLabel("Polynomial 2");
        lblNewLabel_1.setBounds(295, 96, 81, 16);
        getContentPane().add(lblNewLabel_1);
        lblNewLabel_1.setForeground(Color.RED);

        textField_1 = new JTextField();
        textField_1.setBounds(271, 120, 130, 26);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        textField_1.setForeground(Color.RED);

        JButton btnD = new JButton("Derivare P1");
        btnD.setBounds(29, 309, 117, 29);
        getContentPane().add(btnD);
        btnD.setForeground(Color.RED);
        btnD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1String = textField.getText();
                Polynomial p1 = Polynomial.parsePolynomial(p1String);
                Polynomial result = p1.differentiate();
                textFieldD.setText(result.toString());
            }
        });

        textFieldD = new JTextField();
        textFieldD.setBounds(208, 309, 180, 26);
        getContentPane().add(textFieldD);
        textFieldD.setColumns(10);
        textFieldD.setForeground(Color.RED);

        JButton btnS = new JButton("Scadere");
        btnS.setBounds(29, 258, 117, 29);
        getContentPane().add(btnS);
        btnS.setForeground(Color.RED);
        btnS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1String = textField_1.getText();
                String p2String = textField.getText();
                Polynomial p1 = Polynomial.parsePolynomial(p1String);
                Polynomial p2 = Polynomial.parsePolynomial(p2String);
                Polynomial result = p2.subtract(p1);
                textFieldS.setText(result.toString());
            }
        });



        textFieldS = new JTextField();
        textFieldS.setBounds(208, 258, 180, 26);
        getContentPane().add(textFieldS);
        textFieldS.setColumns(10);
        textFieldS.setForeground(Color.RED);

        JButton btnA = new JButton("Adunare");
        btnA.setBounds(29, 207, 117, 29);
        getContentPane().add(btnA);
        btnA.setForeground(Color.RED);


        btnA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1String = textField_1.getText();
                String p2String = textField.getText();
                Polynomial p1 = Polynomial.parsePolynomial(p1String);
                Polynomial p2 = Polynomial.parsePolynomial(p2String);
                Polynomial result = p1.add(p2);
                textFieldA.setText(result.toString());
            }
        });

        textFieldA = new JTextField();
        textFieldA.setBounds(208, 207, 180, 26);
        getContentPane().add(textFieldA);
        textFieldA.setColumns(10);
        textFieldA.setForeground(Color.RED);

        JButton btnM = new JButton("Inmultire");
        btnM.setBounds(29, 360, 117, 29);
        getContentPane().add(btnM);
        btnM.setForeground(Color.RED);
        btnM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p1String = textField_1.getText();
                String p2String = textField.getText();
                Polynomial p1 = Polynomial.parsePolynomial(p1String);
                Polynomial p2 = Polynomial.parsePolynomial(p2String);
                Polynomial result = p1.multiply(p2);
                textFieldM.setText(result.toString());
            }
        });

        textFieldM = new JTextField();
        textFieldM.setBounds(208, 360, 180, 26);
        getContentPane().add(textFieldM);
        textFieldM.setColumns(10);
        textFieldM.setForeground(Color.RED);

        JButton btnI = new JButton("Integrare P2");
        btnI.setBounds(29, 411, 117, 29);
        getContentPane().add(btnI);
        btnI.setForeground(Color.RED);
        btnI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String p2String = textField_1.getText();
                Polynomial p2 = Polynomial.parsePolynomial(p2String);
                Polynomial result = p2.integrate();
               textFieldI.setText(result.toString()+"+c");
            }
        });

        textFieldI = new JTextField();
        textFieldI.setBounds(208, 411, 180, 26);
        getContentPane().add(textFieldI);
        textFieldI.setColumns(10);
        textFieldI.setForeground(Color.RED);

        this.setVisible(true);
        getContentPane().setBackground(Color.lightGray);

    }

}
