package com.aisle.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageHelper {
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap outputBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), bitmap.getConfig());

        Canvas canvasPhoto1 = new Canvas(outputBitmap);
        Paint paintPhoto1 = new Paint();
        paintPhoto1.setAntiAlias(true);
        paintPhoto1.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvasPhoto1.drawRoundRect((new RectF(0, 0, outputBitmap.getWidth(), outputBitmap.getHeight())), pixels, pixels, paintPhoto1);

        return outputBitmap;
    }
}