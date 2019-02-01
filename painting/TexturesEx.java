package com.zetcode;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class DrawingPanel extends JPanel {

    private BufferedImage slate;
    private BufferedImage java;
    private BufferedImage pane;

    public DrawingPanel() {

        loadImages();
    }

    private void loadImages() {

        try {

            slate = ImageIO.read(new File("src/resources/slate.png"));
            java = ImageIO.read(new File("src/resources/java.png"));
            pane = ImageIO.read(new File("src/resources/pane.png"));

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,
                    "Could not load images", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void doDrawing(Graphics g) {

        var g2d = (Graphics2D) g.create();

        var slateTp = new TexturePaint(slate, new Rectangle(0, 0, 90, 60));
        var javaTp = new TexturePaint(java, new Rectangle(0, 0, 90, 60));
        var paneTp = new TexturePaint(pane, new Rectangle(0, 0, 90, 60));

        g2d.setPaint(slateTp);
        g2d.fillRect(10, 15, 90, 60);

        g2d.setPaint(javaTp);
        g2d.fillRect(130, 15, 90, 60);

        g2d.setPaint(paneTp);
        g2d.fillRect(250, 15, 90, 60);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

class TexturesEx extends JFrame {

    public TexturesEx() {

        initUI();
    }

    private void initUI() {

        var drawingPanel = new DrawingPanel();
        add(drawingPanel);

        setTitle("Textures");
        setSize(360, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new TexturesEx();
            ex.setVisible(true);
        });
    }
}
