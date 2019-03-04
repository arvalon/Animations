package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VectorIconAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_icon_animation);

        findViewById(R.id.icon).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ImageView imageView = (ImageView) v;
        final AnimatedVectorDrawable avd = (AnimatedVectorDrawable) imageView.getDrawable();
        avd.start();

    }
}
