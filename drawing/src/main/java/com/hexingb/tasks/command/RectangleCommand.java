/**
 * RectangleCommand.java - draw a rectangle on canvas
 *
 * Author: Bao Hexing <HexingB@qq.com> Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import com.hexingb.tasks.Canvas;

class RectangleCommand implements Command {
    private String x1;
    private String y1;
    private String x2;
    private String y2;

    public void updateArgs(String[] args) {
        x1 = args[1];
        y1 = args[2];
        x2 = args[3];
        y2 = args[4];
    }

    public String toString() {
        return "";
    }

    public Canvas draw(Canvas canvas) {
        // (x1, y1) -> (x1, y2)
        Command lineCommand = CommandFactory.getCommand("L " + x1 + " " + y1 + " " + x1 + " " + y2);
        canvas = lineCommand.draw(canvas);

        // (x1, y1) -> (x2, y1)
        lineCommand = CommandFactory.getCommand("L " + x1 + " " + y1 + " " + x2 + " " + y1);
        canvas = lineCommand.draw(canvas);

        // (x2, y2) -> (x2, y1)
        lineCommand = CommandFactory.getCommand("L " + x2 + " " + y2 + " " + x2 + " " + y1);
        canvas = lineCommand.draw(canvas);

        // (x2, y2) -> (x1, y2)
        lineCommand = CommandFactory.getCommand("L " + x2 + " " + y2 + " " + x1 + " " + y2);
        canvas = lineCommand.draw(canvas);
        return canvas;
    }
}


