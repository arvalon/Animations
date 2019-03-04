package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class KeyFrameActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ROTATION = "rotation";
    public static final int DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_frame);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(final View button) {
        button.setEnabled(false);
        View icon = findViewById(R.id.icon);

        Keyframe keyframe1 = Keyframe.ofFloat(0f, 0f);
        Keyframe keyframe2 = Keyframe.ofFloat(.4f, 90f);
        Keyframe keyframe3 = Keyframe.ofFloat(.6f, 90f);
        Keyframe keyframe4 = Keyframe.ofFloat(1f, 0f);

        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder
                .ofKeyframe(ROTATION, keyframe1, keyframe2, keyframe3, keyframe4);

        ObjectAnimator rotationAnim =
                ObjectAnimator.ofPropertyValuesHolder(icon, propertyValuesHolder);

        rotationAnim.setDuration(DURATION);

        rotationAnim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                button.setEnabled(true);
            }
        });

        rotationAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationAnim.start();
    }
}
