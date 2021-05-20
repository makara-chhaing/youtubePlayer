package com.example.youtubeme;

import android.os.Bundle;
import android.util.Log;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlayer extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener ytInitializedListener;
    private static final String TAG = "MAINNN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        String link = getIntent().getStringExtra("link");
        Log.d(TAG, "link: " + link);
        youTubePlayerView = findViewById(R.id.yt_video);
        ytInitializedListener = new  YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "success: link not null: " + link);
                if(link!=null){
                    youTubePlayer.loadVideo(link);
                    Log.d(TAG, "OnCreate: Video loaded successfully!");
                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "OnCreate: Video load failed!");
                Log.d(TAG, youTubeInitializationResult.toString());
            }
        };
        youTubePlayerView.initialize(YoutubeClass.API_KEY, ytInitializedListener);
    }
}