package ru.arvalon.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class FormAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EMAIL_ERROR = "example@address.com";
    private static final String PASSWORD_ERROR = "Use at least 8 characters";

    private static final int MIN_PASSWORD_LENGTH = 8;

    private TextView mTextViewEmail;
    private TextInputLayout mTextInputLayoutEmail;
    private TextView mTextViewPassword;
    private TextInputLayout mTextInputLayoutPassword;
    private View mViewSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_animation);

        findViewById(R.id.button_save).setOnClickListener(this);

        mTextInputLayoutEmail = findViewById(R.id.input_email);
        mTextViewEmail = mTextInputLayoutEmail.findViewById(R.id.email);
        mTextInputLayoutPassword = findViewById(R.id.input_password);
        mTextViewPassword = mTextInputLayoutPassword.findViewById(R.id.password);
        mViewSuccess = findViewById(R.id.success);
    }

    @Override
    public void onClick(View v) {
        boolean hasError = false;

        // Validate email address
        if (Patterns.EMAIL_ADDRESS.matcher(mTextViewEmail.getText()).matches()) {
            mTextInputLayoutEmail.setErrorEnabled(false);
        } else {
            mTextInputLayoutEmail.setError(EMAIL_ERROR);
            hasError = true;
        }

        // Validate password
        if (mTextViewPassword.getText().length() >= MIN_PASSWORD_LENGTH) {
            mTextInputLayoutPassword.setErrorEnabled(false);
        } else {
            mTextInputLayoutPassword.setError(PASSWORD_ERROR);
            hasError = true;
        }

        if (hasError) {
            mViewSuccess.setVisibility(View.GONE);
        } else {
            mViewSuccess.setVisibility(View.VISIBLE);
        }
    }
}
