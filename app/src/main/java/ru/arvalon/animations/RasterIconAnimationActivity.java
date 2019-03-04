package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RasterIconAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raster_icon_animation);

        findViewById(R.id.icon).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ImageView imageView = (ImageView) v;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
    }
}
