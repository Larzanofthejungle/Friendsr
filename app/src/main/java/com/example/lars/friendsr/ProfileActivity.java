package com.example.lars.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        ImageView personsImage = findViewById(R.id.personsImage);
        TextView personsName = findViewById(R.id.personsName);
        TextView personsBio = findViewById(R.id.personsBio);
        RatingBar personsRating = findViewById(R.id.personsRating);
        personsImage.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));
        personsName.setText(retrievedFriend.getName());
        personsBio.setText(retrievedFriend.getBio());
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        personsRating.setRating(prefs.getFloat(retrievedFriend.getName(), 0));
        personsRating.setOnRatingBarChangeListener(new friendRatingListener());
    }

    private class friendRatingListener implements RatingBar.OnRatingBarChangeListener {

        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            editor.putFloat(retrievedFriend.getName(), v);
            editor.commit();
        }
    }


}
