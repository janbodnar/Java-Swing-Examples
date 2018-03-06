package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class ToolbarsEx extends JFrame {

    public ToolbarsEx() {

        initUI();
    }

    public final void initUI() {

        createToolBars();

        setTitle("Toolbars");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createToolBars() {

        JToolBar toolbar1 = new JToolBar();
        JToolBar toolbar2 = new JToolBar();

        ImageIcon newIcon = new ImageIcon("src/main/resources/new2.png");
        ImageIcon openIcon = new ImageIcon("src/main/resources/open2.png");
        ImageIcon saveIcon = new ImageIcon("src/main/resources/save2.png");
        ImageIcon exitIcon = new ImageIcon("src/main/resources/exit2.png");

        JButton newBtn = new JButton(newIcon);
        JButton openBtn = new JButton(openIcon);
        JButton saveBtn = new JButton(saveIcon);

        toolbar1.add(newBtn);
        toolbar1.add(openBtn);
        toolbar1.add(saveBtn);

        JButton exitBtn = new JButton(exitIcon);
        toolbar2.add(exitBtn);

        exitBtn.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(toolbar1, toolbar2);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0], GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ToolbarsEx ex = new ToolbarsEx();
            ex.setVisible(true);
        });
    }
}
