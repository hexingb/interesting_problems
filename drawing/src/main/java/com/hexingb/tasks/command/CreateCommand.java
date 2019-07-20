/**
 * CreateCommand.java - Crate a canvas
 *
 * Author: Bao Hexing <HexingB@qq.com> Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import com.hexingb.tasks.Canvas;

class CreateCommand implements Command {
    private int width = 0;
    private int height = 0;

    public void updateArgs(String[] args) {
        this.width = Integer.parseInt(args[1]);
        this.height = Integer.parseInt(args[2]);
    }

    public Canvas draw(Canvas canvas) {
        return new Canvas(this.width, this.height);
    }
}

