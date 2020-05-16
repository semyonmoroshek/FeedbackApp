package cm.myprojects.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ReviewActivity extends AppCompatActivity {

    Button btnCancel, btnSendReview;
    EditText editReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnCancel = findViewById(R.id.btn_cancel);
        btnSendReview = findViewById(R.id.btn_send_review);
        editReview = findViewById(R.id.et_message);

        btnCancel.setOnClickListener(View -> returnToMainFeedbackActivity());
        btnSendReview.setOnClickListener(View -> sendReview());
    }

    private void sendReview() {

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
                    finish();
                }
            }, 5000);
        }

    private void returnToMainFeedbackActivity() {
        finish();
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
