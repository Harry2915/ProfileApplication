package harish.hibare.profileapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static harish.hibare.profileapplication.MainActivity.s_email;
import static harish.hibare.profileapplication.MainActivity.s_fname;
import static harish.hibare.profileapplication.MainActivity.s_lname;
import static harish.hibare.profileapplication.MainActivity.s_loc;
import static harish.hibare.profileapplication.MainActivity.s_phone;

public class ProfileActivity extends AppCompatActivity {
    TextView textViewf, textViewl, textViewloc, textViewemail, textViewph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textViewf = findViewById(R.id.tvFisrtPersonName);
        textViewl = findViewById(R.id.tvLastTextPersonName);
        textViewloc = findViewById(R.id.tvLocationPerson);
        textViewemail = findViewById(R.id.tvEmailIDPerson);
        textViewph = findViewById(R.id.tvPhone);

        textViewf.setText(s_fname);
        textViewl.setText(s_lname);
        textViewloc.setText(s_loc);
        textViewemail.setText(s_email);
        textViewph.setText(s_phone);

    }

    public void gouser(View view) {
    }
}