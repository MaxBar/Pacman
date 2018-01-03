package com.company;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Board {
    private static Terminal terminal;
    
    public Board() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
    }
    
    public static Terminal getTerminal() throws IOException {
        /*if(terminal == null) {
            terminal = new DefaultTerminalFactory().createTerminal();
        }*/
        return terminal;
    }
}
