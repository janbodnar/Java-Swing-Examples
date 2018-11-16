package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextPaneEx extends JFrame {

    private JTextPane textPane;

    public TextPaneEx() {

        initUI();
    }

    private void initUI() {

        textPane = new JTextPane();
        var spane = new JScrollPane(textPane);

        textPane.setContentType("text/html");
        textPane.setEditable(false);

        loadFile();

        createLayout(spane);

        setTitle("JTextPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
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

    private void loadFile() {

        try {
            var curDir = System.getProperty("user.dir") + "/";
            textPane.setPage("File:///" + curDir + "test.html");
        } catch (IOException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE,
                    "Failed to load file", ex);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new TextPaneEx();
            ex.setVisible(true);
        });
    }
}
