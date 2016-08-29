package com.example.bi.cycling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2016/8/29.
 */
public class Circle extends View {

    private Paint paint;
    private int radius = 16;
    private int count = com.example.bi.cycling.PagerAdapter.sum;
    private int choosePosition = 0;
    private int gap = 70;

    public void choose(int pos) {
        choosePosition = pos;
        this.invalidate();
    }

    public Circle(Context context) {
        this(context, null);
    }
    public Circle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);

        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int widths = getWidth();
        int height = getHeight();

        int startPx = (widths - (count - 1) * gap) / 2;

        for (int i = 0; i < count; i++) {
            if (choosePosition == i) {
                paint.setColor(Color.CYAN);
                canvas.drawCircle(startPx + i * gap, height - 50, radius + 4, paint);
            } else {
                paint.setColor(Color.WHITE);
                canvas.drawCircle(startPx + i * gap, height - 50, radius, paint);
            }
        }
    }
}
