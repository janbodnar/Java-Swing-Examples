package com.zetcode.events;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DerivedClassEx extends JFrame {

    public DerivedClassEx() {

        initUI();
    }

    private void initUI() {

        var closeBtn = new MyButton("Close");

        createLayout(closeBtn);

        setTitle("Derived class");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

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

    private class MyButton extends JButton implements ActionListener {

        public MyButton(String text) {

            super.setText(text);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            
            var ex = new DerivedClassEx();
            ex.setVisible(true);
        });
    }
}
