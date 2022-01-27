package com.rutuja.myfacedetectionapp.Helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class RectOverRelay extends  GraphicOverlay.Graphic{
    private int reactColor = Color.GREEN;
    private float strokeWidth = 4.5f;
    private Paint reactPaint;
    private GraphicOverlay graphicOverlay;
    private Rect rect;

    public RectOverRelay(GraphicOverlay overlay, Rect rect) {
        super(overlay);
        reactPaint = new Paint();
        reactPaint.setColor(reactColor);
        reactPaint.setStyle(Paint.Style.STROKE);
        reactPaint.setStrokeWidth(strokeWidth);

        this.graphicOverlay = graphicOverlay;
        this.rect = rect;

        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(rect);
        rectF.left = translateX(rectF.left);
        rectF.right = translateX(rectF.right);
        rectF.top = translateX(rectF.top);
        rectF.bottom = translateX(rectF.bottom);

        canvas.drawRect(rect, reactPaint);
    }
}
