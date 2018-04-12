package com.impiger.viewmodeldemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Mohanraj on 4/12/2018.
 */
public class ScoreViewModel extends ViewModel {
    private MutableLiveData<Integer> scoreTeamA = new MutableLiveData();
    private MutableLiveData<Integer> scoreTeamB = new MutableLiveData();

    public void resetScores() {
        scoreTeamA.setValue(0);
        scoreTeamB.setValue(0);
    }
    public void addScoreTeamA(int score) {
        if(scoreTeamA.getValue() == null) {
            scoreTeamA.setValue(0);
        }
        score += scoreTeamA.getValue();
        scoreTeamA.setValue(score);
    }

    public void addScoreTeamB(int score) {
        if(scoreTeamB.getValue() == null) {
            scoreTeamB.setValue(0);
        }
        score += scoreTeamB.getValue();
        scoreTeamB.setValue(score);
    }

    public MutableLiveData<Integer> getScoreTeamA() {
        return scoreTeamA;
    }

    public MutableLiveData<Integer> getScoreTeamB() {
        return scoreTeamB;
    }
}
