package com.company;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Board extends Object{
    private static Terminal terminal;
    private static int origin;
    private static int offset;
    
    public Board() throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 30)).createTerminal();
        terminal.setCursorVisible(false);
        origin = 0;
        offset = 4;
    }

    public static Terminal getTerminal() throws IOException {
        return terminal;
    }

    public static int borderOrigin() throws IOException {
        return origin;
    }

    public static int borderOffset() throws IOException {
        return offset;
    }
    
    public static int getColumns() throws IOException {
        return terminal.getTerminalSize().getColumns();
    }
    
    public static int getRows() throws IOException {
        return terminal.getTerminalSize().getRows();
    }
    
    public static void printField() throws IOException {
        for (int i = 0; i < terminal.getTerminalSize().getColumns(); ++i) {
            for (int j = 3; j < terminal.getTerminalSize().getRows(); ++j) {
                if (j == 3) {
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
