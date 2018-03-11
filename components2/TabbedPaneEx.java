package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Container;
import java.awt.EventQueue;

public class TabbedPaneEx extends JFrame {

    public TabbedPaneEx() {

        initUI();
    }

    private void initUI() {

        JTabbedPane tbp = new JTabbedPane();

        tbp.addTab("First", createPanel("First panel"));
        tbp.addTab("Second", createPanel("Second panel"));
        tbp.addTab("Third", createPanel("Third panel"));

        createLayout(tbp);

        setTitle("JTabbedPane");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel createPanel(String text) {

        JPanel panel = new JPanel();
        JLabel lbl = new JLabel(text);
        panel.add(lbl);

        return panel;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            TabbedPaneEx ex = new TabbedPaneEx();
            ex.setVisible(true);
        });
    }
}
