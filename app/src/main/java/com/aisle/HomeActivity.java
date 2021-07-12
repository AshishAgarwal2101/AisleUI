package com.aisle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aisle.util.ImageHelper;
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

        ConstraintLayout photo1 = findViewById(R.id.home_photo);
        Bitmap bitmapPhoto1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.photo_1)).getBitmap();
        photo1.setBackground(ImageHelper.getRoundedCornerBitmap(bitmapPhoto1, 20, true));

        ConstraintLayout blurPhoto1 = findViewById(R.id.blur_photo_1);
        Bitmap bitmapBlurPhoto1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.photo_2)).getBitmap();
        ImageHelper.blurBitmapWithRenderscript(RenderScript.create(this), bitmapBlurPhoto1);
        blurPhoto1.setBackground(ImageHelper.getRoundedCornerBitmap(bitmapBlurPhoto1, 20, false));

        ConstraintLayout blurPhoto2 = findViewById(R.id.blur_photo_2);
        Bitmap bitmapBlurPhoto2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.photo_3)).getBitmap();
        ImageHelper.blurBitmapWithRenderscript(RenderScript.create(this), bitmapBlurPhoto2);
        blurPhoto2.setBackground(ImageHelper.getRoundedCornerBitmap(bitmapBlurPhoto2, 20, false));


        /*val bitmap = Blurry.with(this)
                .radius(10)
                .sampling(8)
                .capture(findViewById(R.id.right_bottom)).get()*/
    }
}