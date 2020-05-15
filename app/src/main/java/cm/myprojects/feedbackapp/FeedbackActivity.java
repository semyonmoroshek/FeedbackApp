package cm.myprojects.feedbackapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    TextView txtReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtReview = findViewById(R.id.txt_review);

        txtReview.setOnClickListener(View -> openReviewActivity());

    }

    private void openReviewActivity() {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }


    public void rootLayoutTapped(View view) {
        try {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
