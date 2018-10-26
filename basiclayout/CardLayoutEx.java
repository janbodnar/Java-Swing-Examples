package com.zetcode;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutEx extends JFrame {

    private ImageIcon horka1;
    private ImageIcon horka2;
    private ImageIcon horka3;
    private ImageIcon horka4;
    private ImageIcon previ;
    private ImageIcon nexti;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public CardLayoutEx() {

        initUI();
    }

    private void initUI() {

        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(50, 50, 50));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        horka1 = new ImageIcon("src/resources/horka1.jpg");
        horka2 = new ImageIcon("src/resources/horka2.jpg");
        horka3 = new ImageIcon("src/resources/horka3.jpg");
        horka4 = new ImageIcon("src/resources/horka4.jpg");

        previ = new ImageIcon("src/resources/previous.png");
        nexti = new ImageIcon("src/resources/next.png");

        var label1 = new JLabel(horka1);
        var label2 = new JLabel(horka2);
        var label3 = new JLabel(horka3);
        var label4 = new JLabel(horka4);

        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(label3);
        mainPanel.add(label4);

        add(mainPanel);

        var prevButton = new JButton(previ);
        prevButton.addActionListener((e) -> cardLayout.previous(mainPanel));

        var nextButton = new JButton(nexti);
        nextButton.addActionListener((e) -> cardLayout.next(mainPanel));

        var btnPanel = new JPanel();
        btnPanel.setBackground(new Color(50, 50, 50));
        btnPanel.add(prevButton);
        btnPanel.add(nextButton);

        add(btnPanel, BorderLayout.SOUTH);

        pack();

        setTitle("Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new CardLayoutEx();
            ex.setVisible(true);
        });
    }
}
