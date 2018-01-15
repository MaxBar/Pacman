package com.company.States;

import com.company.GameScore;
import java.util.Comparator;

public class ScoreCompare implements Comparator<GameScore> {

    public int compare(GameScore points_1, GameScore points_2) {

        int gs1 = points_1.getGameScore();
        int gs2 = points_2.getGameScore();

        if (gs1 > gs2){
            return -1;
        }else if (gs1 < gs2){
            return +1;
        }else{
            return 0;
        }
    }
}
