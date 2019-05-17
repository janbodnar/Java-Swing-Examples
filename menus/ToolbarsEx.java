package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.EventQueue;

public class ToolbarsEx extends JFrame {

    public ToolbarsEx() {

        initUI();
    }

    private void initUI() {

        createToolBars();

        setTitle("Toolbars");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createToolBars() {

        var toolbar1 = new JToolBar();
        var toolbar2 = new JToolBar();

        var newIcon = new ImageIcon("src/resources/new2.png");
        var openIcon = new ImageIcon("src/resources/open2.png");
        var saveIcon = new ImageIcon("src/resources/save2.png");
        var exitIcon = new ImageIcon("src/resources/exit2.png");

        var newBtn = new JButton(newIcon);
        var openBtn = new JButton(openIcon);
        var saveBtn = new JButton(saveIcon);

        toolbar1.add(newBtn);
        toolbar1.add(openBtn);
        toolbar1.add(saveBtn);

        var exitBtn = new JButton(exitIcon);
        toolbar2.add(exitBtn);

        exitBtn.addActionListener((e) -> System.exit(0));

        createLayout(toolbar1, toolbar2);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
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

            var ex = new ToolbarsEx();
            ex.setVisible(true);
        });
    }
}
