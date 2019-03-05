package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;
import ru.arvalon.animations.interpolations.InterpolatorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author arvalon
 */
public class MainActivity extends AppCompatActivity {

    static final int LOGO_SIZE = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.anim_label);

        Glide.with(this)
                .asGif()
                .load(R.drawable.animation)
                .apply(new RequestOptions().override(LOGO_SIZE, LOGO_SIZE))
                .into(imageView);

        findViewById(R.id.rotation_demo_button).setOnClickListener(v ->
            startActivity(new Intent(this, RotationDemoActivity.class)));

        findViewById(R.id.interpolation_demo_button).setOnClickListener(v ->
                startActivity(new Intent(this, InterpolatorActivity.class)));

        findViewById(R.id.circularrevealtransition_demo_button).setOnClickListener(v ->
                startActivity(new Intent(this, CircularRevealTransitionActivity.class)));

        findViewById(R.id.keyframe_demo_button).setOnClickListener(v ->
                startActivity(new Intent(this, KeyFrameActivity.class)));

        findViewById(R.id.scene_transition_button).setOnClickListener(v ->
                startActivity(new Intent(this, SceneTransitionActivity.class)));

        findViewById(R.id.form_animation_button).setOnClickListener(v ->
                startActivity(new Intent(this, FormAnimationActivity.class)));

        findViewById(R.id.raster_icon_animation_button).setOnClickListener(v ->
                startActivity(new Intent(this, RasterIconAnimationActivity.class)));

        findViewById(R.id.vector_icon_animation_button).setOnClickListener(v ->
                startActivity(new Intent(this, VectorIconAnimationActivity.class)));
    }
}