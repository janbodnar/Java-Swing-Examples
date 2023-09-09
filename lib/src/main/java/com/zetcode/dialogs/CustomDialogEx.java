package com.zetcode.dialogs;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static javax.swing.GroupLayout.Alignment.CENTER;


class AboutDialog extends JDialog {

    public AboutDialog(Frame parent) {
        super(parent);

        initUI();
    }

    private void initUI() {

        var icon = new ImageIcon("src/resources/notes.png");
        var imgLabel = new JLabel(icon);

        var textLabel = new JLabel("Notes, 1.23");
        textLabel.setFont(new Font("Serif", Font.BOLD, 13));

        var okBtn = new JButton("OK");
        okBtn.addActionListener(event -> dispose());

        createLayout(textLabel, imgLabel, okBtn);

        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("About Notes");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addGap(200)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(30)
                .addComponent(arg[0])
                .addGap(20)
                .addComponent(arg[1])
                .addGap(20)
                .addComponent(arg[2])
                .addGap(30)
        );

        pack();
    }
}

public class CustomDialogEx extends JFrame
        implements ActionListener {

    public CustomDialogEx() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Simple Dialog");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menubar = new JMenuBar();

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        var aboutMemuItem = new JMenuItem("About");
        aboutMemuItem.setMnemonic(KeyEvent.VK_A);
        helpMenu.add(aboutMemuItem);

        aboutMemuItem.addActionListener(this);

        menubar.add(fileMenu);
        menubar.add(Box.createGlue());
        menubar.add(helpMenu);
        setJMenuBar(menubar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        showAboutDialog();
    }

    private void showAboutDialog() {

        var aboutDialog = new AboutDialog(this);
        aboutDialog.setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new CustomDialogEx();
            ex.setVisible(true);
        });
    }
}
