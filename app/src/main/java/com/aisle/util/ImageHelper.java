package com.aisle.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class ImageHelper {
    public static BitmapDrawable getRoundedCornerBitmap(Bitmap bitmap, int pixels, boolean isSquare) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if(isSquare){
            int min = Math.min(height, width);
            height = min;
            width = min;
        }
        Bitmap outputBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());

        Canvas canvasPhoto1 = new Canvas(outputBitmap);
        Paint paintPhoto1 = new Paint();
        paintPhoto1.setAntiAlias(true);
        paintPhoto1.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvasPhoto1.drawRoundRect((new RectF(0, 0, outputBitmap.getWidth(), outputBitmap.getHeight())), pixels, pixels, paintPhoto1);

        return new BitmapDrawable(outputBitmap);
    }

    public static void blurBitmapWithRenderscript(RenderScript rs, Bitmap bitmap2) {
        // this will blur the bitmapOriginal with a radius of 25
        // and save it in bitmapOriginal
        // use this constructor for best performance, because it uses
        // USAGE_SHARED mode which reuses memory
        final Allocation input = Allocation.createFromBitmap(rs, bitmap2);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        // must be >0 and <= 25
        script.setRadius(25f);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bitmap2);
    }
}