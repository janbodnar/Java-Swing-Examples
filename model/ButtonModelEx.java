package com.zetcode;

import javax.swing.AbstractAction;
import javax.swing.DefaultButtonModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class ButtonModelEx extends JFrame {

    private JButton okBtn;
    private JLabel enabledLbl;
    private JLabel pressedLbl;
    private JLabel armedLbl;
    private JCheckBox checkBox;

    public ButtonModelEx() {

        initUI();
    }

    private void initUI() {

        okBtn = new JButton("OK");
        okBtn.addChangeListener(new DisabledChangeListener());
        checkBox = new JCheckBox();
        checkBox.setAction(new CheckBoxAction());

        enabledLbl = new JLabel("Enabled: true");
        pressedLbl = new JLabel("Pressed: false");
        armedLbl = new JLabel("Armed: false");

        createLayout(okBtn, checkBox, enabledLbl, pressedLbl, armedLbl);

        setTitle("ButtonModel");
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
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addGap(80)
                        .addComponent(arg[1]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1]))
                .addGap(40)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        pack();
    }

    private class DisabledChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {

            DefaultButtonModel model = (DefaultButtonModel) okBtn.getModel();

            if (model.isEnabled()) {
                enabledLbl.setText("Enabled: true");
            } else {
                enabledLbl.setText("Enabled: false");
            }

            if (model.isArmed()) {
                armedLbl.setText("Armed: true");
            } else {
                armedLbl.setText("Armed: false");
            }

            if (model.isPressed()) {
                pressedLbl.setText("Pressed: true");
            } else {
                pressedLbl.setText("Pressed: false");
            }
        }
    }

    private class CheckBoxAction extends AbstractAction {

        public CheckBoxAction() {
            super("Disabled");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (okBtn.isEnabled()) {
                okBtn.setEnabled(false);
            } else {
                okBtn.setEnabled(true);
            }
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ButtonModelEx ex = new ButtonModelEx();
            ex.setVisible(true);
        });
    }
}
