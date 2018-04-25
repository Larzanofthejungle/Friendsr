package com.example.lars.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();
    String[] friendNames = {"Arya", "Cersei", "Daenerys", "Jaime", "Jon", "Jorah", "Margaery", "Melisandre", "Sansa", "Tyrion"};
    String[] friendBios = {"A girl has no name", "Shame, Shame, Shame", "Mother of Dragons", "The Kingslayer",
            "Knows Nothing", "Master of the Friendzone", "Desperate to be Queen",
            "Better than Dr. Frankenstein", "Miss Abuse", "“That's what I do. I drink and I know things.”"};
    int[] friendDrawables = {R.drawable.arya, R.drawable.cersei, R.drawable.daenerys,
            R.drawable.jaime, R.drawable.jon, R.drawable.jorah, R.drawable.margaery,
            R.drawable.melisandre, R.drawable.sansa, R.drawable.tyrion};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < friendNames.length; i++) {
            friends.add(new Friend(friendNames[i], friendBios[i], friendDrawables[i]));
        }
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item , friends);
        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            intent.putExtra("clicked_position", i);
            startActivity(intent);
        }
    }
}
