package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import java.awt.Container;
import java.awt.EventQueue;

/*
Java Swing tutorial
Simple text drag and drop example

Author: Jan Bodnar
Website: http://zetcode.com
*/

public class SimpleDnD extends JFrame {

    private JTextField field;
    private JButton button;

    public SimpleDnD() {

        initUI();
    }

    private void initUI() {
      
        button = new JButton("Button");
        field = new JTextField(15);

        field.setDragEnabled(true);
        button.setTransferHandler(new TransferHandler("text"));

        createLayout(field, button);

        setTitle("Simple Drag & Drop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            SimpleDnD ex = new SimpleDnD();
            ex.setVisible(true);
        });
    }
}
