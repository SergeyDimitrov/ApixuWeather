package com.example.pb.apixuweather.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import static android.view.View.GONE;
import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.View.MeasureSpec.UNSPECIFIED;
import static android.view.View.VISIBLE;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class AnimationUtils {

    private static final int ANIMATION_DURATION = 300;
    private static final int ANIMATION_DURATION_LONG = 700;

    public static void slideUpAnimation(View v) {
        v.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(ANIMATION_DURATION_LONG)
                .start();
    }

    public static void expandCollapseAnimation(final View v, final View child, final RecyclerView parent, final boolean expand) {
        child.setVisibility(expand ? VISIBLE : GONE);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(v.getWidth(), EXACTLY);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, UNSPECIFIED);
        v.measure(widthMeasureSpec, heightMeasureSpec);
        int oldHeight = v.getHeight();
        int newHeight = v.getMeasuredHeight();

        ValueAnimator viewAnimator = ValueAnimator.ofFloat(oldHeight, newHeight);
        viewAnimator.setDuration(ANIMATION_DURATION).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            private float initY = v.getY();

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float value = (Float) valueAnimator.getAnimatedValue();
                v.getLayoutParams().height = value.intValue();
                int bottom = (int) (v.getY() + value.intValue());
                if (bottom > parent.getBottom()) {
                    parent.scrollBy(0, bottom - parent.getBottom());
                }
                v.requestLayout();
            }
        });
        viewAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                v.getLayoutParams().height = WRAP_CONTENT;
                v.requestLayout();
            }
        });
        viewAnimator.start();
    }
}
