package com.zetcode;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;

public class ListDnD extends JFrame {

    private JTextField field;
    private DefaultListModel model;

    public ListDnD() {

        initUI();
    }

    private void initUI() {

        var scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(180, 150));

        model = new DefaultListModel();
        var myList = new JList(model);

        myList.setDropMode(DropMode.INSERT);
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myList.setTransferHandler(new ListHandler());

        field = new JTextField(15);
        field.setDragEnabled(true);

        scrollPane.getViewport().add(myList);

        createLayout(field, scrollPane);

        setTitle("ListDrop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class ListHandler extends TransferHandler {

        public boolean canImport(TransferSupport support) {

            if (!support.isDrop()) {
                return false;
            }

            return support.isDataFlavorSupported(DataFlavor.stringFlavor);
        }

        public boolean importData(TransferSupport support) {

            if (!canImport(support)) {
                return false;
            }

            var transferable = support.getTransferable();
            String line;

            try {
                line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception e) {
                return false;
            }

            var dl = (JList.DropLocation) support.getDropLocation();
            int index = dl.getIndex();

            String[] data = line.split("[,\\s]");

            for (String item : data) {

                if (!item.isEmpty())
                    model.add(index++, item.trim());
            }

            return true;
        }
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            var ex = new ListDnD();
            ex.setVisible(true);
        });
    }
}
