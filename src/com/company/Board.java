package com.company;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Board {
    private static Terminal terminal;
    
    public Board() throws IOException {
        terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 30)).createTerminal();
        terminal.setCursorVisible(false);
    }
    
    public static Terminal getTerminal() throws IOException {
        return terminal;
    }
    
    public int[] getSize() throws IOException {
        int[] c = new int[2];
        c[0] = terminal.getTerminalSize().getRows();
        c[1] = terminal.getTerminalSize().getColumns();
        return c;
    }
}
