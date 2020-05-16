package cm.myprojects.feedbackapp;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainFeedbackActivity extends AppCompatActivity {

    TextView txtReview;
    Button btnSendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        setTitle("");

        txtReview = findViewById(R.id.txt_review);
        btnSendFeedback = findViewById(R.id.btn_send_feedback_main);

        txtReview.setOnClickListener(View -> openReviewActivity());
        btnSendFeedback.setOnClickListener(View -> sendFeedBack());

    }

    private void sendFeedBack() {

        Dialog dialog = new Dialog(this);
        dialog.setTitle("Thank you for feedback!");
        dialog.setContentView(R.layout.my_dialog);
        dialog.show();

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
                dialog.cancel();
            }
        }, 5000);
    }

    private void openReviewActivity() {
        Intent intent = new Intent(this, ReviewActivity.class);
        startActivity(intent);
    }
}
