package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class CheckBoxMenuItemEx extends JFrame {

    private JLabel statusbar;

    public CheckBoxMenuItemEx() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        statusbar = new JLabel("Ready");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.SOUTH);

        setTitle("JCheckBoxMenuItem");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menubar = new JMenuBar();
        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);

        var showStatusBarMenuItem = new JCheckBoxMenuItem("Show statubar");
        showStatusBarMenuItem.setMnemonic(KeyEvent.VK_S);
        showStatusBarMenuItem.setDisplayedMnemonicIndex(5);
        showStatusBarMenuItem.setSelected(true);

        showStatusBarMenuItem.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                statusbar.setVisible(true);
            } else {
                statusbar.setVisible(false);
            }
        });

        viewMenu.add(showStatusBarMenuItem);

        menubar.add(fileMenu);
        menubar.add(viewMenu);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new CheckBoxMenuItemEx();
            ex.setVisible(true);
        });
    }
}
