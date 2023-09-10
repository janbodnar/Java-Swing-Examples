package com.zetcode.painting;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

class DrawPanel extends JPanel {

    private Image myImage;

    public DrawPanel() {

        initPanel();
    }

    private void initPanel() {

        loadImage();
        var dm = new Dimension(myImage.getWidth(null), myImage.getHeight(null));
        setPreferredSize(dm);
    }

    private void loadImage() {

        myImage = new ImageIcon(getClass().getResource("/icesid.jpg")).getImage();
    }

    private void doDrawing(Graphics g) {

        var g2d = (Graphics2D) g;

        g2d.drawImage(myImage, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class DrawImageEx extends JFrame {

    public DrawImageEx() {

        initUI();
    }

    private void initUI() {

        var drawPanel = new DrawPanel();
        add(drawPanel);

        setTitle("Image");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new DrawImageEx();
            ex.setVisible(true);
        });
    }
}
