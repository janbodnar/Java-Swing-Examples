package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.EventQueue;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

public class MessageDialogsEx extends JFrame {

    private JPanel pnl;

    public MessageDialogsEx() {

        initUI();
    }

    private void initUI() {

        pnl = (JPanel) getContentPane();

        var warBtn = new JButton("Warning");
        var errBtn = new JButton("Error");
        var queBtn = new JButton("Question");
        var infBtn = new JButton("Information");

        warBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "A deprecated call!", "Warning", JOptionPane.WARNING_MESSAGE));

        errBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Could not open file!", "Error", JOptionPane.ERROR_MESSAGE));

        queBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Are you sure to quit?", "Question", JOptionPane.QUESTION_MESSAGE));

        infBtn.addActionListener(event -> JOptionPane.showMessageDialog(pnl,
                "Download completed.", "Information", JOptionPane.INFORMATION_MESSAGE));

        createLayout(warBtn, errBtn, queBtn, infBtn);

        setTitle("Message dialogs");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[2]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[3]))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1]))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[2])
                        .addComponent(arg[3]))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gl.linkSize(arg[0], arg[1], arg[2], arg[3]);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var md = new MessageDialogsEx();
            md.setVisible(true);
        });
    }
}
