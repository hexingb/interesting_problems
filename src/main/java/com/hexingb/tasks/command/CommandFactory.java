/**
 * CommandFactory.java - command factory
 *
 * Author: Bao Hexing <HexingB@qq.com>
 * Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    static Map<String, Command> commands = null;
    static {
        commands = new HashMap<String, Command>();
        commands.put("C", new CreateCommand());
        commands.put("L", new LineCommand());
        commands.put("R", new RectangleCommand());
        commands.put("B", new FillCommand());
    }

    public static Command getCommand(String input) {
	String cmdToken[] = input.trim().split(" ");
	return getCommand(cmdToken);
    }

    public static Command getCommand(String[] args) {
        Command command = commands.get(args[0]);
        if (command == null) {
            throw new IllegalArgumentException("invalid command");
        }
        command.updateArgs(args);
	return command;
    }
}

