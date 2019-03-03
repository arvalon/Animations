package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;

public class RotationDemoActivity extends AppCompatActivity {

    static final int SHORT_DURATION = 2000;
    static final int LONG_DURATION = 3000;
    static final int ANGLE = 180;
    static final float BIG_SCALE = 0.5f;
    static final float SHORT_SCALE = 0.25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_demo);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        TextView tv = findViewById(R.id.text);

        btn1.setOnClickListener(v ->
            tv.animate().setDuration(SHORT_DURATION).rotationY(ANGLE).scaleY(BIG_SCALE));

        btn2.setOnClickListener(v ->
            tv.animate()
                    .setDuration(SHORT_DURATION)
                    .scaleX(SHORT_SCALE)
                    .scaleY(SHORT_SCALE)
                    .setListener(new AnimatorListenerAdapter() {

                        @Override
                        public void onAnimationEnd(Animator animation) {

                            Display display = getWindowManager().getDefaultDisplay();
                            Point size = new Point();
                            display.getSize(size);
                            int width = size.x;
                            int height = size.y;

                            tv.animate().setDuration(LONG_DURATION).x(width).y(height);

                        }
                    })
        );
    }
}