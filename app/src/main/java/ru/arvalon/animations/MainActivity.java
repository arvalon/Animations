package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author arvalon
 *
 * ActionBar color
 * https://stackoverflow.com/questions/18288402/how-to-set-custom-actionbar-color-style/18288460
 */
public class MainActivity extends AppCompatActivity {

    static final int LOGO_SIZE = 500;

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

        findViewById(R.id.scene_transition_button).setOnClickListener(v ->
                startActivity(new Intent(this, SceneTransitionActivity.class)));

    }
}