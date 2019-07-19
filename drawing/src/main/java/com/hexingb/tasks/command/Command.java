/**
 * Command.java - Command
 *
 * Author: Bao Hexing <HexingB@qq.com>
 * Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import com.hexingb.tasks.Canvas;

public interface Command {
    public void updateArgs(String[] args);

    public Canvas draw(Canvas canvas);
}

