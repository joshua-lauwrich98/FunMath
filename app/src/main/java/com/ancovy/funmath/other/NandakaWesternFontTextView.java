package com.ancovy.funmath.other;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by DarKnight98 on 3/14/2017.
 */

public class NandakaWesternFontTextView extends TextView {
    public NandakaWesternFontTextView(Context context) {
        super(context);
        init();
    }

    public NandakaWesternFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NandakaWesternFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/gomarice_nandaka_western.ttf");
            setTypeface(tf);
        }
    }
}
