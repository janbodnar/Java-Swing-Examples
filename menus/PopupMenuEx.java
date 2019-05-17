package com.zetcode;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenuEx extends JFrame {

    private JPopupMenu popupMenu;

    public PopupMenuEx() {

        initUI();
    }

    private void initUI() {

        createPopupMenu();

        setTitle("JPopupMenu");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createPopupMenu() {

        popupMenu = new JPopupMenu();

        var maximizeMenuItem = new JMenuItem("Maximize");
        maximizeMenuItem.addActionListener((e) -> {
            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                maximizeMenuItem.setEnabled(false);
            }
        });

        popupMenu.add(maximizeMenuItem);

        var quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener((e) -> System.exit(0));

        popupMenu.add(quitMenuItem);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                    maximizeMenuItem.setEnabled(true);
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new PopupMenuEx();
            ex.setVisible(true);
        });
    }
}
