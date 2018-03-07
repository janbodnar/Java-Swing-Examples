package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovingWindowEx extends JFrame
        implements ComponentListener {

    private JLabel labelx;
    private JLabel labely;

    public MovingWindowEx() {

        initUI();
    }

    private void initUI() {

        addComponentListener(this);

        labelx = new JLabel("x: ");
        labelx.setFont(new Font("Serif", Font.BOLD, 14));
        labelx.setBounds(20, 20, 60, 25);

        labely = new JLabel("y: ");
        labely.setFont(new Font("Serif", Font.BOLD, 14));
        labely.setBounds(20, 45, 60, 25);

        createLayout(labelx, labely);

        setTitle("Moving window");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addGap(130)
        );

        pack();
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {

        int x = e.getComponent().getX();
        int y = e.getComponent().getY();

        labelx.setText("x: " + x);
        labely.setText("y: " + y);
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingWindowEx ex = new MovingWindowEx();
            ex.setVisible(true);
        });
    }
}
