package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Add http://gph.is/2q6SOmY
 * @author arvalon
 */
public class MainActivity extends AppCompatActivity {

    static final String GIF = "https://media.giphy.com/media/h8PoRDsoFWFO0/giphy.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*WebView webView = findViewById(R.id.anim_label2);

        /*webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setLoadsImagesAutomatically(true);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.loadUrl("file:///android_asset/animation.gif");*/

        ImageView imageView = findViewById(R.id.anim_label);

        //Glide.with(this).load(GIF).into(imageView);

        Glide.with(this).load(R.drawable.animation).into(imageView);

    }
}