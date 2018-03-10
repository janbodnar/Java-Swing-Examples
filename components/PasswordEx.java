package com.zetcode;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class PasswordEx extends JFrame {

    private JTextField loginField;
    private JPasswordField passField;

    public PasswordEx() {

        initUI();
    }

    private void initUI() {

        JLabel lbl1 = new JLabel("Login");
        JLabel lbl2 = new JLabel("Password");

        loginField = new JTextField(15);
        passField = new JPasswordField(15);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new SubmitAction());

        createLayout(lbl1, loginField, lbl2, passField, submitButton);

        setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class SubmitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            doSubmitAction();
        }

        private void doSubmitAction() {

            String login = loginField.getText();
            char[] passwd = passField.getPassword();

            if (!login.isEmpty() && passwd.length != 0) {
                System.out.format("User %s entered %s password%n",
                        login, String.valueOf(passwd));
            }

            Arrays.fill(passwd, '0');
        }
    }

    private void createLayout(Component... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
                .addGap(50)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[2])
                        .addComponent(arg[3], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(arg[4]))
                .addGap(50)
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            PasswordEx ex = new PasswordEx();
            ex.setVisible(true);
        });
    }
}
