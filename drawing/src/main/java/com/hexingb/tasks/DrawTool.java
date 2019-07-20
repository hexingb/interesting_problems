/**
 * Draw.java - Drawing problem
 *
 * Author: Bao Hexing <HexingB@qq.com> Created: 16 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks;

import com.hexingb.tasks.command.Command;
import com.hexingb.tasks.command.CommandFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrawTool {
    public static void main(String[] args) {
        BufferedReader reader = null;
        Canvas canvas = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (true) {
            try {
                String input = reader.readLine();
                String cmdToken[] = input.trim().split(" ");
                if (cmdToken.length == 0) {
                    System.out.println("Invalid input, continue");
                    continue;
                }

                if ("Q".equals(cmdToken[0])) {
                    break;
                }

                Command command = CommandFactory.getCommand(cmdToken);

                // BAD if return result from CreateCommand is omitted
                // CreateCommand should be considered separately, like QuitCommand?
                canvas = command.draw(canvas);

                canvas.display();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
