package de.cfranzen.adventofcode.day10;

import java.util.Arrays;

public class CRT {

    private static final char SYMBOL_LIT = '#';
    private static final char SYMBOL_DARK = ' ';

    private static final int WIDTH = 40;
    private static final int HEIGHT = 6;
    private static final int CYCLES = WIDTH * HEIGHT;

    private final char[] printout = new char[CYCLES];

    public void print(final CpuPipeline cpu) {
        Arrays.fill(printout, SYMBOL_DARK);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                final int cycle = i * WIDTH + j + 1;
                final int position = cpu.getValueXAtCycle(cycle);

                if (Math.abs(j - position) <= 1) {
                    this.printout[i * WIDTH + j] = SYMBOL_LIT;
                } else {
                    this.printout[i * WIDTH + j] = SYMBOL_DARK;
                }
            }
        }


        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(printout[i * WIDTH + j]);
            }
            System.out.println();
        }
    }
}
