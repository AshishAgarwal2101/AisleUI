package com.aisle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        BadgeDrawable notesBadge = bottomNavigationView.getOrCreateBadge(R.id.notesIcon);
        notesBadge.setVisible(true);
        notesBadge.setNumber(9);
        notesBadge.setVerticalOffset(22);
        notesBadge.setBackgroundColor(getResources().getColor(R.color.badgeTextColor));

        BadgeDrawable matchesBadge = bottomNavigationView.getOrCreateBadge(R.id.matchesIcon);
        matchesBadge.setVisible(true);
        matchesBadge.setMaxCharacterCount(3);
        matchesBadge.setBackgroundColor(getResources().getColor(R.color.badgeTextColor));
        matchesBadge.setVerticalOffset(22);
        matchesBadge.setNumber(102);
    }
}