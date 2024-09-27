package com.zetcode.resizablecomponent;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class ResizableBorder implements Border {

    private int dist = 8;

    int[] locations = {
            SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.WEST,
            SwingConstants.EAST, SwingConstants.NORTH_WEST,
            SwingConstants.NORTH_EAST, SwingConstants.SOUTH_WEST,
            SwingConstants.SOUTH_EAST
    };

    int[] cursors = {
            Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR,
            Cursor.E_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR,
            Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR
    };

    public ResizableBorder(int dist) {
        this.dist = dist;
    }

    @Override
    public Insets getBorderInsets(Component component) {
        return new Insets(dist, dist, dist, dist);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component component, Graphics g, int x, int y,
                            int w, int h) {

        g.setColor(Color.black);
        g.drawRect(x + dist / 2, y + dist / 2, w - dist, h - dist);

        if (component.hasFocus()) {

            for (int location : locations) {

                var rect = getRectangle(x, y, w, h, location);

                if (rect != null) {

                    g.setColor(Color.WHITE);
                    g.fillRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
                    g.setColor(Color.BLACK);
                    g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
                }
            }
        }
    }

    private Rectangle getRectangle(int x, int y, int w, int h, int location) {

        return switch (location) {
            case SwingConstants.NORTH -> new Rectangle(x + w / 2 - dist / 2, y, dist, dist);
            case SwingConstants.SOUTH -> new Rectangle(x + w / 2 - dist / 2, y + h - dist, dist, dist);
            case SwingConstants.WEST -> new Rectangle(x, y + h / 2 - dist / 2, dist, dist);
            case SwingConstants.EAST -> new Rectangle(x + w - dist, y + h / 2 - dist / 2, dist, dist);
            case SwingConstants.NORTH_WEST -> new Rectangle(x, y, dist, dist);
            case SwingConstants.NORTH_EAST -> new Rectangle(x + w - dist, y, dist, dist);
            case SwingConstants.SOUTH_WEST -> new Rectangle(x, y + h - dist, dist, dist);
            case SwingConstants.SOUTH_EAST -> new Rectangle(x + w - dist, y + h - dist, dist, dist);
            default -> new Rectangle();
        };
    }

    public int getCursor(MouseEvent me) {

        var c = me.getComponent();
        int w = c.getWidth();
        int h = c.getHeight();

        for (int i = 0; i < locations.length; i++) {

            var rect = getRectangle(0, 0, w, h, locations[i]);

            if (rect != null && rect.contains(me.getPoint())) {
                return cursors[i];
            }
        }

        return Cursor.MOVE_CURSOR;
    }
}
