package com.zetcode;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class ProgressBarEx extends JFrame {

    private Timer timer;
    private JProgressBar progBar;
    private JButton startBtn;
    private final int MAX_VAL = 100;

    public ProgressBarEx() {

        initUI();
    }

    private void initUI() {

        progBar = new JProgressBar();
        progBar.setStringPainted(true);

        startBtn = new JButton("Start");
        startBtn.addActionListener(new ClickAction());

        timer = new Timer(50, new UpdateBarListener());

        createLayout(progBar, startBtn);

        setTitle("JProgressBar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
    }

    private class UpdateBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int val = progBar.getValue();

            if (val >= MAX_VAL) {

                timer.stop();
                startBtn.setText("End");
                return;
            }

            progBar.setValue(++val);
        }
    }

    private class ClickAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (timer.isRunning()) {

                timer.stop();
                startBtn.setText("Start");

            } else if (!"End".equals(startBtn.getText())) {

                timer.start();
                startBtn.setText("Stop");
            }
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ProgressBarEx ex = new ProgressBarEx();
            ex.setVisible(true);
        });
    }
}
