/**
 * Canvas.java - Canvas
 *
 * Author: Bao Hexing <HexingB@qq.com>
 * Created: 17 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

package com.hexingb.tasks;

public class Canvas {
    private char[] pixels = null;
    private int width = 0;
    private int height = 0;

    public Canvas(int width, int height) {
	// 2 for boundaries
	this.width = width + 2;
	this.height = height + 2;

	pixels = new char[this.width * this.height];

	for (int i = 0; i < pixels.length; ++i) {
	    pixels[i] = ' ';
	}

	for (int i = 0; i < this.width; ++i) {
	    pixels[i] = '-';
	    pixels[(this.height - 1) * this.width + i] = '-';
	}

	for (int i = 1; i < this.height - 1; ++i) {
	    pixels[i * this.width] = '|';
	    pixels[(i + 1) * this.width - 1] = '|';
	}
    }

    public void setPixel(int x, int y, char c) {
	int pos = y * width + x;
	pixels[pos] = c;
	display();
    }

    public boolean isBoundary(int x, int y) {
	char c = pixels[y * width + x];
	if (c == '-' || c == '|' || c == 'x') {
	    return true;
	}
	return false;
    }

    public char getColor(int x, int y) {
	return pixels[y * width + x];
    }

    public boolean contains(int x, int y) {
	if (x + 1 >= width || y + 1 >= height) {
	    return false;
	}
	return true;
    }

    public void display() {
	for (int h = 0; h < height; ++h) {
	    for (int w = 0; w < width; ++w) {
		System.out.print(pixels[h * this.width + w]);
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
