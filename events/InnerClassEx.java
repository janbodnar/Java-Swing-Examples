package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class InnerClassEx extends JFrame {

    public InnerClassEx() {

        initUI();
    }

    private void initUI() {

        JButton closeBtn = new JButton("Close");

        ButtonCloseListener listener = new ButtonCloseListener();
        closeBtn.addActionListener(listener);

        createLayout(closeBtn);

        setTitle("Inner class example");
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
                .addGap(220)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(220)
        );

        pack();
    }

    private class ButtonCloseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            InnerClassEx ex = new InnerClassEx();
            ex.setVisible(true);
        });
    }
}
