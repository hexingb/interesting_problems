/**
 * LineCommand.java - draw a line on canvas
 *
 * Author: Bao Hexing <HexingB@qq.com>
 * Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import com.hexingb.tasks.Canvas;

public class LineCommand implements Command {
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    public void updateArgs(String[] args) {
        this.x1 = Integer.parseInt(args[1]);
        this.y1 = Integer.parseInt(args[2]);
        this.x2 = Integer.parseInt(args[3]);
        this.y2 = Integer.parseInt(args[4]);
    }

    public Canvas draw(Canvas canvas) {
        if (canvas.contains(x1, y1) == false ||
            canvas.contains(x2, y2) == false) {
            throw new IllegalArgumentException("invalid position");
        }

        if (x1 == x2) { // a vertical line
            int start = Math.min(y1, y2);
            int end = Math.max(y1, y2);
                
            for (int h = start; h <= end; ++h) {
                canvas.setPixel(x1, h, 'x');
            }
        }

        if (y1 == y2) { // a horizontal line
            int start = Math.min(x1, x2);
            int end = Math.max(x1, x2);
            for (int w = start; w <= end; ++w) {
                canvas.setPixel(w, y1, 'x');
            }
        }

        return canvas;
    }
}

