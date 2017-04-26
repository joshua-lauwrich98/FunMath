package com.ancovy.funmath.other;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by DarKnight98 on 4/23/2017.
 */

public class PiratePlunderFontButton extends Button {
    public PiratePlunderFontButton(Context context) {
        super(context);
        init();
    }

    public PiratePlunderFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PiratePlunderFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PiratePlunderFontButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Pirate Plunder.ttf");
            setTypeface(tf);
        }
    }
}
