package com.chelpus;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.widget.TextView;

public class GradientTextView extends TextView {
    public GradientTextView(Context context) {
        super(context, null, -1);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs, -1);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            getPaint().setShader(new LinearGradient(0.0f, 0.0f, (float) getWidth(), 0.0f, Color.parseColor("#FF6699cc"), Color.parseColor("#906699cc"), TileMode.CLAMP));
        }
    }
}
