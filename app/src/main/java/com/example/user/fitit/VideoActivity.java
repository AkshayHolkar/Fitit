package com.example.user.fitit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.net.Uri;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoActivity extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerViewDemo;
    Button btn_Play;
    YouTubePlayer.OnInitializedListener onInitializedListenerDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btn_Play = (Button) findViewById(R.id.btn_play);        //play button
        youTubePlayerViewDemo = (YouTubePlayerView) findViewById(R.id.youtubeDemoPlay);     //video window

        onInitializedListenerDemo = new YouTubePlayer.OnInitializedListener() {     //initialisation
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //include logs
                youTubePlayer.loadVideo("5QCBkwmsOk0");     //video url, single video
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                //include logs
            }
        };

        btn_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //button on click retrieves API key
                youTubePlayerViewDemo.initialize(YoutubeConfig.getApiKey(), onInitializedListenerDemo);
            }
        });
    }

}


