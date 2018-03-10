package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonMnemonicEx extends JFrame implements ActionListener {

    public ButtonMnemonicEx() {

        initUI();
    }

    private void initUI() {

        JButton showBtn = new JButton("Show");
        showBtn.addActionListener(this);
        showBtn.setMnemonic(KeyEvent.VK_S);

        createLayout(showBtn);

        setTitle("JButtons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(150)
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Button clicked",
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ButtonMnemonicEx ex = new ButtonMnemonicEx();
            ex.setVisible(true);
        });
    }
}
