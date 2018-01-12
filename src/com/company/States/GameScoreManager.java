package com.company.States;

import com.company.Board;
import com.company.GameScore;

import java.io.*;
import java.util.*;

public class GameScoreManager {
    private ArrayList<GameScore> points;
    private static final String HIGHSCORE_FILE = "highscore.dat";

    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public GameScoreManager() {
        points = new ArrayList<GameScore>();
    }

    public ArrayList<GameScore> getPoints() {
        loadScoreFile();
        sort();
        return points;
    }

    private void sort() {
        ScoreCompare compare = new ScoreCompare();
        Collections.sort(points, compare);
    }

    public void addPoints(String name, int points) {
        loadScoreFile();
        addPoints(name, points);
        updateScoreFile();
    }

    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            points = (ArrayList<GameScore>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(points);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<GameScore> points;
        points = getPoints();

        int i = 0;
        int x = points.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + points.get(i).getName() + "\t\t" + points.get(i).getGameScore() + "\n";
            i++;
        }
        return highscoreString;
    }

    public static void printHighScore() throws IOException { // Funkar ej och går ej att kalla på i PlayState?!
        GameScoreManager highscore = new GameScoreManager();
        Board.getTerminal().newTextGraphics().putString((Board.getTerminal().getTerminalSize().getColumns() / 2) - 10, (Board.getTerminal().getTerminalSize().getRows()) - 22, "Highscore:" + highscore.getHighscoreString());
    }
}
