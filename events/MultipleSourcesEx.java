package com.zetcode;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class MultipleSourcesEx extends JFrame {

    private JLabel statusBar;

    public MultipleSourcesEx() {

        initUI();
    }

    private void initUI() {

        statusBar = new JLabel("Ready");
        statusBar.setBorder(BorderFactory.createEtchedBorder());

        ButtonListener butListener = new ButtonListener();

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(butListener);

        JButton openBtn = new JButton("Open");
        openBtn.addActionListener(butListener);

        JButton findBtn = new JButton("Find");
        findBtn.addActionListener(butListener);

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(butListener);

        createLayout(closeBtn, openBtn, findBtn, saveBtn, statusBar);

        setTitle("Multiple Sources");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4], GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addPreferredGap(RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arg[4])
        );

        gl.linkSize(arg[0], arg[1], arg[2], arg[3]);

        pack();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton o = (JButton) e.getSource();
            String label = o.getText();
            statusBar.setText(" " + label + " button clicked");
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MultipleSourcesEx ex = new MultipleSourcesEx();
            ex.setVisible(true);
        });
    }
}
