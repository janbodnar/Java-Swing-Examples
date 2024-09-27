package com.zetcode.menus;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ShortcutsEx extends JFrame {

    public ShortcutsEx() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Mnemonics and accelerators");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menuBar = new JMenuBar();

        var iconNew = new ImageIcon(getClass().getResource("/new.png"));
        var iconOpen = new ImageIcon(getClass().getResource("/open.png"));
        var iconSave = new ImageIcon(getClass().getResource("/save.png"));
        var iconExit = new ImageIcon(getClass().getResource("/exit.png"));

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var newMenuItem = new JMenuItem(new MenuItemAction("New", iconNew,
                KeyEvent.VK_N));

        var openMenuItem = new JMenuItem(new MenuItemAction("Open", iconOpen,
                KeyEvent.VK_O));

        var saveMenuItem = new JMenuItem(new MenuItemAction("Save", iconSave,
                KeyEvent.VK_S));

        var exitMenuItem = new JMenuItem("Exit", iconExit);
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                InputEvent.CTRL_DOWN_MASK));

        exitMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private static class MenuItemAction extends AbstractAction {

        public MenuItemAction(String text, ImageIcon icon,
                              Integer mnemonic) {
            super(text);

            putValue(SMALL_ICON, icon);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(e.getActionCommand());
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new ShortcutsEx();
            ex.setVisible(true);
        });
    }
}
