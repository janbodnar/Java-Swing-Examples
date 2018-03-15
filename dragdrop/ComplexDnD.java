package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
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
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

/*
Java Swing tutorial
Complex drag and drop example

Author: Jan Bodnar
Website: http://zetcode.com
 */

public class ComplexDnD extends JFrame
        implements DragGestureListener {

    private JPanel leftPanel;

    public ComplexDnD() {

        initUI();
    }

    private void initUI() {

        JButton colourBtn = new JButton("Choose Color");
        colourBtn.setFocusable(false);

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.red);
        leftPanel.setPreferredSize(new Dimension(100, 100));

        colourBtn.addActionListener(event -> {

            Color color = JColorChooser.showDialog(this, "Choose Color", Color.white);
            leftPanel.setBackground(color);
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setPreferredSize(new Dimension(100, 100));

        MyDropTargetListener mtl = new MyDropTargetListener(rightPanel);

        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(leftPanel,
                DnDConstants.ACTION_COPY, this);

        createLayout(colourBtn, leftPanel, rightPanel);

        setTitle("Complex drag and drop example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void dragGestureRecognized(DragGestureEvent event) {

        Cursor cursor = null;
        JPanel panel = (JPanel) event.getComponent();

        Color color = panel.getBackground();

        if (event.getDragAction() == DnDConstants.ACTION_COPY) {
            cursor = DragSource.DefaultCopyDrop;
        }

        event.startDrag(cursor, new TransferableColor(color));
    }

    private class MyDropTargetListener extends DropTargetAdapter {

        private final DropTarget dropTarget;
        private final JPanel panel;

        public MyDropTargetListener(JPanel panel) {
            this.panel = panel;

            dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY,
                    this, true, null);
        }


        public void drop(DropTargetDropEvent event) {

            try {

                Transferable tr = event.getTransferable();
                Color col = (Color) tr.getTransferData(TransferableColor.colorFlavor);

                if (event.isDataFlavorSupported(TransferableColor.colorFlavor)) {

                    event.acceptDrop(DnDConstants.ACTION_COPY);
                    this.panel.setBackground(col);
                    event.dropComplete(true);
                    return;
                }

                event.rejectDrop();
            } catch (Exception e) {

                e.printStackTrace();
                event.rejectDrop();
            }
        }
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(30)
                .addComponent(arg[1])
                .addGap(30)
                .addComponent(arg[2])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            ComplexDnD ex = new ComplexDnD();
            ex.setVisible(true);
        });
    }
}


class TransferableColor implements Transferable {

    protected static final DataFlavor colorFlavor =
            new DataFlavor(Color.class, "A Color Object");

    protected static final DataFlavor[] supportedFlavors = {
            colorFlavor,
            DataFlavor.stringFlavor,
    };

    private final Color color;

    public TransferableColor(Color color) {

        this.color = color;
    }

    public DataFlavor[] getTransferDataFlavors() {

        return supportedFlavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {

        return flavor.equals(colorFlavor) ||
                flavor.equals(DataFlavor.stringFlavor);
    }


    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException {

        if (flavor.equals(colorFlavor)) {
            return color;
        } else if (flavor.equals(DataFlavor.stringFlavor)) {
            return color.toString();
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
