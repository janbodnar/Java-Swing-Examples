package com.zetcode;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class RadioButtonEx extends JFrame
        implements ItemListener {

    private JLabel sbar;

    public RadioButtonEx() {

        initUI();
    }

    private void initUI() {

        JLabel lbl = new JLabel("Difficulty");

        ButtonGroup group = new ButtonGroup();

        JRadioButton rb1 = new JRadioButton("Easy", true);
        JRadioButton rb2 = new JRadioButton("Medium");
        JRadioButton rb3 = new JRadioButton("Hard");

        group.add(rb1);
        group.add(rb2);
        group.add(rb3);

        sbar = new JLabel("Selected: Easy");

        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);

        createLayout(lbl, rb1, rb2, rb3, sbar);

        setSize(350, 250);
        setTitle("Radio buttons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        int sel = e.getStateChange();

        if (sel == ItemEvent.SELECTED) {

            JRadioButton button = (JRadioButton) e.getSource();
            String text = button.getText();

            StringBuilder sb = new StringBuilder("Selected: ");
            sb.append(text);

            sbar.setText(sb.toString());
        }
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addPreferredGap(RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arg[4])
        );
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RadioButtonEx ex = new RadioButtonEx();
            ex.setVisible(true);
        });
    }
}
