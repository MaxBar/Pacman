package com.company;

public class DeltaTime {
    private static long last_time;
    private static long time;
    private static float deltaTime;
    private static int fps;
    private static double elapsedTime;
    
    public DeltaTime() {
        last_time = System.nanoTime();
        time = last_time;
        deltaTime = 0;
        fps = 1000/60;
        elapsedTime = 0;
    }
    
    public static float getDeltaTime() {
        time = System.nanoTime();
        deltaTime = (int)((time - last_time) / 1000000) + deltaTime;
        last_time = time;
        return deltaTime;
    }
    
    public static void setDeltaTime(int value) {
        deltaTime = value;
    }
    
    public static int getFPS() {
        return fps;
    }
}
