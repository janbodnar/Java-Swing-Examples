package com.zetcode.components2;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import java.awt.EventQueue;

public class SliderEx2 extends JFrame {

    private JSlider slider;
    private JLabel lbl;

    private ImageIcon mute;
    private ImageIcon min;
    private ImageIcon med;
    private ImageIcon max;

    public SliderEx2() {

        initUI();
    }

    private void initUI() {

        loadImages();

        slider = new JSlider(0, 150, 0);

        slider.addChangeListener((ChangeEvent event) -> {

            int value = slider.getValue();

            if (value == 0) {
                lbl.setIcon(mute);
            } else if (value > 0 && value <= 30) {
                lbl.setIcon(min);
            } else if (value > 30 && value < 80) {
                lbl.setIcon(med);
            } else {
                lbl.setIcon(max);
            }
        });

        lbl = new JLabel(mute, JLabel.CENTER);

        createLayout(slider, lbl);

        setTitle("JSlider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void loadImages() {

        mute = new ImageIcon(getClass().getResource("/mute.png"));
        min = new ImageIcon(getClass().getResource("/min.png"));
        med = new ImageIcon(getClass().getResource("/med.png"));
        max = new ImageIcon(getClass().getResource("/max.png"));
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new SliderEx2();
            ex.setVisible(true);
        });
    }
}
