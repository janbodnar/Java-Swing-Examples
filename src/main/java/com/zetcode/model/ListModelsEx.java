package com.zetcode.model;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class ListModelsEx extends JFrame {

    private DefaultListModel<String> model;
    private JList<String> myList;
    private JButton remAllBtn;
    private JButton addBtn;
    private JButton renBtn;
    private JButton delBtn;

    public ListModelsEx() {

        initUI();
    }

    private void createList() {

        model = new DefaultListModel<>();
        model.addElement("Amelie");
        model.addElement("Aguirre, der Zorn Gottes");
        model.addElement("Fargo");
        model.addElement("Exorcist");
        model.addElement("Schindler's myList");

        myList = new JList<>(model);
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        myList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int index = myList.locationToIndex(e.getPoint());
                    var item = model.getElementAt(index);
                    var text = JOptionPane.showInputDialog("Rename item", item);

                    String newItem;

                    if (text != null) {
                        newItem = text.trim();
                    } else {
                        return;
                    }

                    if (!newItem.isEmpty()) {

                        model.remove(index);
                        model.add(index, newItem);

                        var selModel = myList.getSelectionModel();
                        selModel.setLeadSelectionIndex(index);
                    }
                }
            }
        });
    }

    private void createButtons() {

        remAllBtn = new JButton("Remove All");
        addBtn = new JButton("Add");
        renBtn = new JButton("Rename");
        delBtn = new JButton("Delete");

        addBtn.addActionListener(e -> {

            var text = JOptionPane.showInputDialog("Add a new item");
            String item;

            if (text != null) {
                item = text.trim();
            } else {
                return;
            }

            if (!item.isEmpty()) {

                model.addElement(item);
            }
        });

        delBtn.addActionListener(event -> {

            var selModel = myList.getSelectionModel();

            int index = selModel.getMinSelectionIndex();

            if (index >= 0) {
                model.remove(index);
            }
        });

        renBtn.addActionListener(e -> {

            var selModel = myList.getSelectionModel();
            int index = selModel.getMinSelectionIndex();

            if (index == -1) {
                return;
            }

            var item = model.getElementAt(index);
            var text = JOptionPane.showInputDialog("Rename item", item);
            String newItem;

            if (text != null) {
                newItem = text.trim();
            } else {
                return;
            }

            if (!newItem.isEmpty()) {

                model.remove(index);
                model.add(index, newItem);
            }
        });

        remAllBtn.addActionListener(e -> model.clear());
    }

    private void initUI() {

        createList();
        createButtons();

        var scrollPane = new JScrollPane(myList);
        createLayout(scrollPane, addBtn, renBtn, delBtn, remAllBtn);

        setTitle("JList models");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(arg[0])
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
        );

        gl.linkSize(addBtn, renBtn, delBtn, remAllBtn);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new ListModelsEx();
            ex.setVisible(true);
        });
    }
}
