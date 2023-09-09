package com.zetcode.model;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class DocumentModelEx extends JFrame {

    private StyledDocument sdoc;
    private JTextPane textPane;

    public DocumentModelEx() {

        initUI();
    }

    private void initUI() {

        createToolbar();

        var panel =  new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        textPane = new JTextPane();
        sdoc = textPane.getStyledDocument();
        initStyles(textPane);

        panel.add(new JScrollPane(textPane));
        add(panel);
        pack();

        setTitle("Document Model");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createToolbar() {

        var toolbar = new JToolBar();

        var bold = new ImageIcon("src/main/resources/bold.png");
        var italic = new ImageIcon("src/main/resources/italic.png");
        var strike = new ImageIcon("src/main/resources/strike.png");
        var underline = new ImageIcon("src/main/resources/underline.png");

        var boldBtn = new JButton(bold);
        var italBtn = new JButton(italic);
        var striBtn = new JButton(strike);
        var undeBtn = new JButton(underline);

        toolbar.add(boldBtn);
        toolbar.add(italBtn);
        toolbar.add(striBtn);
        toolbar.add(undeBtn);

        add(toolbar, BorderLayout.NORTH);

        boldBtn.addActionListener(e -> sdoc.setCharacterAttributes(
                textPane.getSelectionStart(),
                textPane.getSelectionEnd() - textPane.getSelectionStart(),
                textPane.getStyle("Bold"), false));

        italBtn.addActionListener(e -> sdoc.setCharacterAttributes(
                textPane.getSelectionStart(),
                textPane.getSelectionEnd() - textPane.getSelectionStart(),
                textPane.getStyle("Italic"), false));

        striBtn.addActionListener(e -> sdoc.setCharacterAttributes(
                textPane.getSelectionStart(),
                textPane.getSelectionEnd() - textPane.getSelectionStart(),
                textPane.getStyle("Strike"), false));

        undeBtn.addActionListener(e -> sdoc.setCharacterAttributes(
                textPane.getSelectionStart(),
                textPane.getSelectionEnd() - textPane.getSelectionStart(),
                textPane.getStyle("Underline"), false));
    }

    private void initStyles(JTextPane textPane) {

        var style = textPane.addStyle("Bold", null);
        StyleConstants.setBold(style, true);

        style = textPane.addStyle("Italic", null);
        StyleConstants.setItalic(style, true);

        style = textPane.addStyle("Underline", null);
        StyleConstants.setUnderline(style, true);

        style = textPane.addStyle("Strike", null);
        StyleConstants.setStrikeThrough(style, true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new DocumentModelEx();
            ex.setVisible(true);
        });
    }
}
