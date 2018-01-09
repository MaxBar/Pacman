package com.company;

public class DeltaTime {
    private static long last_time;
    private static long time;
    private static int deltaTime;
    private static int fps;
    private static double elapsedTime;
    //private static int second = 100;
    //private static int frames = 2;
    
    public DeltaTime() {
        last_time = System.nanoTime();
        fps = 50;//second / frames;
        elapsedTime = 0;
    }
    
    public static int getDeltaTime() {
        time = System.nanoTime();
        deltaTime = (int)((time - last_time) / 1000000) + deltaTime;
        last_time = time;
        return deltaTime;
    }
    
    public static void setDeltaTime(int value) {
        deltaTime = value;
    }
    
    public static int getFPS() {
        System.out.println(fps);
        return fps;
    }
    
    public static double getElapsedTime() {
        elapsedTime += deltaTime;
        return elapsedTime;
    }
}
