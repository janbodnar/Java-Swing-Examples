package com.zetcode.firstprograms;

import java.awt.EventQueue;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import static java.util.Objects.requireNonNull;

public class FrameIconEx extends JFrame {

    public FrameIconEx() {

        initUI();
    }

    private void initUI() {

        var webIcon = new ImageIcon(requireNonNull(this.getClass().getResource("/web.png")));

        setIconImage(webIcon.getImage());

        setTitle("Icon");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new FrameIconEx();
            ex.setVisible(true);
        });
    }
}
