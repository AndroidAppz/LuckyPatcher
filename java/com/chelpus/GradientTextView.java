/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.LinearGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.widget.TextView
 *  java.lang.String
 */
package com.chelpus;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class GradientTextView
extends TextView {
    public GradientTextView(Context context) {
        super(context, null, -1);
    }

    public GradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (bl) {
            this.getPaint().setShader((Shader)new LinearGradient(0.0f, 0.0f, (float)this.getWidth(), 0.0f, Color.parseColor((String)"#FF6699cc"), Color.parseColor((String)"#906699cc"), Shader.TileMode.CLAMP));
        }
    }
}

