package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RemoveListenerEx extends JFrame {

    private JLabel lbl;
    private JButton addBtn;
    private JCheckBox activeBox;
    private ButtonListener buttonlistener;
    private int count = 0;

    public RemoveListenerEx() {

        initUI();
    }

    private void initUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        addBtn = new JButton("+");
        buttonlistener = new ButtonListener();

        activeBox = new JCheckBox("Active listener");
        activeBox.addItemListener((ItemEvent event) -> {
            if (activeBox.isSelected()) {
                addBtn.addActionListener(buttonlistener);
            } else {
                addBtn.removeActionListener(buttonlistener);
            }
        });

        lbl = new JLabel("0");

        createLayout(addBtn, activeBox, lbl);

        setTitle("Remove listener");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[2]))
                .addGap(30)
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1]))
                .addGap(30)
                .addComponent(arg[2])
        );

        pack();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            lbl.setText(Integer.toString(++count));
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RemoveListenerEx ex = new RemoveListenerEx();
            ex.setVisible(true);
        });
    }
}
