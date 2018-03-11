package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;

public class ComboBoxEx extends JFrame
        implements ItemListener {

    private JLabel display;
    private JComboBox<String> box;
    private String[] distros;

    public ComboBoxEx() {

        initUI();
    }

    private void initUI() {

        distros = new String[]{"Ubuntu", "Redhat", "Arch",
                "Debian", "Mint"};

        box = new JComboBox<>(distros);
        box.addItemListener(this);

        display = new JLabel("Ubuntu");

        createLayout(box, display);

        setTitle("JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createParallelGroup(BASELINE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            display.setText(e.getItem().toString());
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ComboBoxEx ex = new ComboBoxEx();
            ex.setVisible(true);
        });
    }
}
