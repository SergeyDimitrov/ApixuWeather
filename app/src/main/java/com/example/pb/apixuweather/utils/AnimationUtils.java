package com.example.pb.apixuweather.utils;

import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class AnimationUtils {

    private static final int ANIMATION_DURATION = 700;

    public static void slideUpAnimation(View v) {
        v.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(ANIMATION_DURATION)
                .start();
    }
}
