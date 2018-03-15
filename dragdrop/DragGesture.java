package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

/*
Java Swing tutorial
Drag gesture example

Author: Jan Bodnar
Website: http://zetcode.com
 */

public class DragGesture extends JFrame implements
        DragGestureListener, Transferable {

    public DragGesture() {

        initUI();
    }

    private void initUI() {

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setPreferredSize(new Dimension(120, 120));

        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(redPanel,
                DnDConstants.ACTION_COPY, this);

        createLayout(redPanel);

        setTitle("Drag Gesture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void dragGestureRecognized(DragGestureEvent event) {

        System.out.println("grag gesture");
        Cursor cursor = null;

        if (event.getDragAction() == DnDConstants.ACTION_COPY) {

            cursor = DragSource.DefaultCopyDrop;
        }

        event.startDrag(cursor, this);
    }

    public Object getTransferData(DataFlavor flavor) {
        return null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[0];
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return false;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addComponent(arg[0])
                .addGap(50)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addComponent(arg[0])
                .addGap(50)
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            DragGesture ex = new DragGesture();
            ex.setVisible(true);
        });
    }
}
