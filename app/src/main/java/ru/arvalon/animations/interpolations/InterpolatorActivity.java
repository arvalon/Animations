package ru.arvalon.animations.interpolations;

import androidx.appcompat.app.AppCompatActivity;
import ru.arvalon.animations.R;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ANIMATE = "This text will animate";
    public static final String AMAZING = "Was that amazing?";

    private Spinner mSpinner;
    private TextView mDurationTextView;
    private View mBoxToAnimate;
    private TextView mTextViewToAnimate;
    private int mHorizontalPadding;
    private View mButtonAnimate;
    private View mButtonReset;

    private ValueAnimator mValueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        mSpinner = findViewById(R.id.spinner);
        mSpinner.setAdapter(new InterpolatorAdapter(this));
        mDurationTextView = findViewById(R.id.duration);
        mBoxToAnimate = findViewById(R.id.box_to_animate);
        mTextViewToAnimate = findViewById(R.id.text_to_animate);
        mButtonAnimate = findViewById(R.id.button_animate);
        mButtonAnimate.setOnClickListener(this);
        mButtonReset = findViewById(R.id.button_reset);
        mButtonReset.setOnClickListener(this);

        mHorizontalPadding = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interpolation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(final View v) {
        if (v == mButtonAnimate) {
            v.setEnabled(false);
            animate();
            return;
        }
        if (v == mButtonReset) {
            mBoxToAnimate.setX(mHorizontalPadding);
            mButtonAnimate.setEnabled(true);
            mBoxToAnimate.animate().cancel();
            if (mValueAnimator != null) {
                mValueAnimator.cancel();
                mValueAnimator = null;
                mTextViewToAnimate.setText(ANIMATE);
            }
        }

    }

    private void animate() {

        final TimeInterpolator interpolator = (TimeInterpolator) mSpinner.getSelectedItem();
        final CharSequence durationText = mDurationTextView.getText();
        long duration;

        try {
            duration = Long.valueOf(durationText.toString());
        } catch (NumberFormatException e) {
            duration = 1000;
            mDurationTextView.setText("1000");
        }

        // Animate the box
        final int animationEnd = ((View) mBoxToAnimate.getParent()).getWidth() - mBoxToAnimate.getWidth() - mHorizontalPadding;
        mBoxToAnimate.animate().x(animationEnd).setDuration(duration).setInterpolator(interpolator);

        // Animate the text
        mValueAnimator = ValueAnimator.ofObject(new CharSequenceEvaluator(), mTextViewToAnimate.getText(), AMAZING);
        mValueAnimator.setDuration(duration);
        mValueAnimator.setInterpolator(interpolator);

        mValueAnimator.addUpdateListener(animation -> {
            final CharSequence text = (CharSequence) animation.getAnimatedValue();
            mTextViewToAnimate.setText(text);
        });

        mValueAnimator.start();
    }
}
