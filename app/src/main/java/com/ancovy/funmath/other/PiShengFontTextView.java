package com.ancovy.funmath.other;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by DarKnight98 on 3/14/2017.
 */

public class PiShengFontTextView extends TextView {
    public PiShengFontTextView(Context context) {
        super(context);
        init();
    }

    public PiShengFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PiShengFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Pi Sheng.otf");
            setTypeface(tf);
        }
    }
}
