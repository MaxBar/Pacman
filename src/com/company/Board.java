package com.company;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Board extends Object{
    private static Terminal terminal;
    
    public Board() throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 30)).createTerminal();
        terminal.setCursorVisible(false);
    }

    public static Terminal getTerminal() throws IOException {
        return terminal;
    }

    public int[] getRows() throws IOException {
        int[] row = new int[1];
        row[0] = terminal.getTerminalSize().getRows();
        return row;
    }

    public int[] getColumns() throws IOException {
        int[] col = new int[1];
        col[0] = terminal.getTerminalSize().getColumns();
        return col;
    }
    
    public static void printField() throws IOException {
        for (int i = 0; i < terminal.getTerminalSize().getColumns(); ++i) {
            for (int j = 0; j < terminal.getTerminalSize().getRows(); ++j) {
                if (j == 0) {
                    terminal.newTextGraphics().putString(i, j, "\u2588");
                } else if (j == terminal.getTerminalSize().getRows() - 1) {
                    terminal.newTextGraphics().putString(i, j, "\u2588");
                } else if (i == 0) {
                    terminal.newTextGraphics().putString(i, j, "\u2588");
                } else if (i == Board.getTerminal().getTerminalSize().getColumns() - 1) {
                    terminal.newTextGraphics().putString(i, j, "\u2588");
                }
            }
        }
    }
}
