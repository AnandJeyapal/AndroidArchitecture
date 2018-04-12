package com.impiger.viewmodeldemo;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScoreViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
//        viewModel.resetScores();
        findViewById(R.id.a_three_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamA(3);
            }
        });
        findViewById(R.id.a_two_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamA(2);
            }
        });
        findViewById(R.id.a_free_throw_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamA(1);
            }
        });
        findViewById(R.id.b_three_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamB(3);
            }
        });
        findViewById(R.id.b_two_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamB(2);
            }
        });
        findViewById(R.id.b_free_throw_score_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addScoreTeamB(1);
            }
        });
        viewModel.getScoreTeamA().observe(this, item -> {
            ((TextView)findViewById(R.id.team_a_score)).setText(item.toString());
        });
        viewModel.getScoreTeamB().observe(this, item -> {
            ((TextView)findViewById(R.id.team_b_score)).setText(item.toString());
        });
    }
}
