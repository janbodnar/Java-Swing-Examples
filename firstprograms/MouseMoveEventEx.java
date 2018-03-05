package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMoveEventEx extends JFrame {

    private JLabel coords;

    public MouseMoveEventEx() {

        initUI();
    }

    private void initUI() {

        coords = new JLabel("");

        createLayout(coords);

        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                int x = e.getX();
                int y = e.getY();

                String text = String.format("x: %d, y: %d", x, y);

                coords.setText(text);
            }
        });

        setTitle("Mouse move events");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(130)
        );

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MouseMoveEventEx ex = new MouseMoveEventEx();
            ex.setVisible(true);
        });
    }
}
