package com.company;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class InitState {
    private static Terminal terminal;
    
    public static void init() throws InterruptedException, IOException {
        //TerminalSize terminalSize = new TerminalSize(10,10);
        terminal = new DefaultTerminalFactory().createTerminal();

        
        /*terminal.enterPrivateMode();
        terminal.setCursorPosition(10, 5);
        terminal.putCharacter('H');
        terminal.setBackgroundColor(TextColor.ANSI.BLUE);
        terminal.flush();*/
        
    }
    
    public static Terminal getTerminal() {
        return terminal;
    }
}
