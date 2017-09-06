package com.example.pb.apixuweather.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import static android.view.View.GONE;
import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.View.MeasureSpec.UNSPECIFIED;
import static android.view.View.VISIBLE;

public class AnimationUtils {

    private static final int ANIMATION_DURATION = 700;

    public static void slideUpAnimation(View v) {
        v.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(ANIMATION_DURATION)
                .start();
    }

    public static void expandCollapseAnimation(final View v, final View child, final boolean expand) {
        child.setVisibility(expand ? VISIBLE : GONE);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(v.getWidth(), EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, UNSPECIFIED);
        v.measure(widthMeasureSpec, heightMeasureSpec);
        int oldHeight = v.getHeight();
        int newHeight = v.getMeasuredHeight();

        ValueAnimator animator = ValueAnimator.ofFloat(oldHeight, newHeight);
        animator.setDuration(ANIMATION_DURATION).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float value = (Float) valueAnimator.getAnimatedValue();
                v.getLayoutParams().height = value.intValue();
                v.requestLayout();
            }
        });
        animator.start();
    }
}
