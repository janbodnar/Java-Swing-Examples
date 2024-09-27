package com.zetcode.basiclayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;

public class BorderLayoutEx2 extends JFrame {

    public BorderLayoutEx2() {

        initUI();
    }

    private void initUI() {

        var menubar = new JMenuBar();
        var fileMenu = new JMenu("File");

        menubar.add(fileMenu);
        setJMenuBar(menubar);

        var toolbar = new JToolBar();
        toolbar.setFloatable(false);

        var exitIcon = new ImageIcon(getClass().getResource("/basiclayout/exit.png"));
        var exitBtn = new JButton(exitIcon);
        exitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        toolbar.add(exitBtn);

        add(toolbar, BorderLayout.NORTH);

        var vertical = new JToolBar(JToolBar.VERTICAL);
        vertical.setFloatable(false);
        vertical.setMargin(new Insets(10, 5, 5, 5));

        var driveIcon = new ImageIcon(getClass().getResource("/basiclayout/drive.png"));
        var compIcon = new ImageIcon(getClass().getResource("/computer.png"));
        var printIcon = new ImageIcon(getClass().getResource("/printer.png"));

        var driveBtn = new JButton(driveIcon);
        driveBtn.setBorder(new EmptyBorder(3, 0, 3, 0));

        var compBtn = new JButton(compIcon);
        compBtn.setBorder(new EmptyBorder(3, 0, 3, 0));
        var printBtn = new JButton(printIcon);
        printBtn.setBorder(new EmptyBorder(3, 0, 3, 0));

        vertical.add(driveBtn);
        vertical.add(compBtn);
        vertical.add(printBtn);

        add(vertical, BorderLayout.WEST);

        add(new JTextArea(), BorderLayout.CENTER);

        var statusbar = new JLabel(" Statusbar");
        add(statusbar, BorderLayout.SOUTH);

        setSize(400, 350);
        setTitle("BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new BorderLayoutEx2();
            ex.setVisible(true);
        });
    }
}
