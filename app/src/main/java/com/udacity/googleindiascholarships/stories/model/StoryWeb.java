package com.udacity.googleindiascholarships.stories.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.udacity.googleindiascholarships.R;

public class StoryWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_web);

        WebView StoryWebView = (WebView) findViewById(R.id.wVStory);
        Intent intent= this.getIntent();
        String StoryURL = intent.getExtras().getString("StoryUrl");
        StoryWebView.loadUrl(StoryURL);
    }
}
