/**
 * FillCommand.java - fill a area with color
 *
 * Author: Bao Hexing <HexingB@qq.com> Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import com.hexingb.tasks.Canvas;

class FillCommand implements Command {
    private int x = 0;
    private int y = 0;
    private char color = 0;

    public void updateArgs(String[] args) {
        x = Integer.parseInt(args[1]);
        y = Integer.parseInt(args[2]);
        color = (char) args[3].charAt(0);
    }

    public Canvas draw(Canvas canvas) {
        if (canvas.contains(x, y) == false) {
            throw new IllegalArgumentException("invalid position");
        }

        detectArea(canvas, x, y);

        return canvas;
    }

    private void detectArea(Canvas canvas, int x, int y) {
        // input color must not be '|', '-', 'x'
        // and assume the area is fully filled by one color, if exist.
        if (canvas.isBoundary(x, y) == false && this.color != canvas.getColor(x, y)) {
            canvas.setPixel(x, y, color);
            // canvas.display();
            detectArea(canvas, x - 1, y);
            detectArea(canvas, x + 1, y);
            detectArea(canvas, x, y - 1);
            detectArea(canvas, x, y + 1);
        }
    }
}

