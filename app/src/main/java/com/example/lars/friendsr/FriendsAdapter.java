package com.example.lars.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;
    ImageView friendsImage;
    TextView friendsText;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        friendsImage = convertView.findViewById(R.id.friendsPicture);
        friendsText = convertView.findViewById(R.id.friendsName);
        friendsImage.setImageDrawable(getContext().getDrawable(friends.get(position).getDrawableId()));
        friendsText.setText(friends.get(position).getName());
        return convertView;
    }
}
