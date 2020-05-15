package cm.myprojects.feedbackapp;


import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    TextView txtReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtReview = findViewById(R.id.txt_review);
        txtReview.setOnClickListener(View -> createNotificationTemplate());

    }

    private void createNotificationTemplate() {

        String review = "";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Send review");

//        final EditText input = new EditText(this);
//
//        input.setInputType(InputType.TYPE_CLASS_TEXT |
//                InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE |
//                InputType.TYPE_TEXT_FLAG_MULTI_LINE);
//        builder.setView(input);
//
//        builder.setPositiveButton("Save", (dialog, whichButton) -> {
//
//            templateMessage = input.getText().toString();
//            Log.i("message3", templateMessage);
//            mDatabase.updateTemplateObject(templateMessage, 1);
//            Log.i("template", mDatabase.getAllTemplates().get(0).toString());
//        });
//
//        builder.setNegativeButton("Cancel", (dialog, whichButton) -> {
//            dialog.cancel();
//            Log.i("message4", templateMessage);
//        });
        builder.show();
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
