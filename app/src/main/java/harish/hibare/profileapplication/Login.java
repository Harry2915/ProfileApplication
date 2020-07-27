package harish.hibare.profileapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity  implements View.OnClickListener {
    EditText editTextemail,editTextpass;
    Button buttonlogin,buttonregister;
    public static SQLiteDatabase db;
    public static AlertDialog.Builder builder_Login;
    static String string_fname, string_lname, string_loc, string_email, string_phone, string_pass, string_cnf_pass;
    Cursor cursor;
    public static int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        editTextemail=findViewById(R.id.logmail);
        editTextpass=findViewById(R.id.logpass);
        buttonlogin=findViewById(R.id.loginbtn);
        buttonregister=findViewById(R.id.regbtn);
        builder_Login=new AlertDialog.Builder(this);
        buttonregister.setOnClickListener(this);
        buttonlogin.setOnClickListener(this);
        db=openOrCreateDatabase("mydb",Context.MODE_PRIVATE,null);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.loginbtn:
                String email = editTextemail.getText().toString().toLowerCase().trim();
                String password = editTextpass.getText().toString().trim();

                if (editTextemail.length() == 0 || editTextpass.length()==0) {
                    showMessage("Error", "Enter correct Details");
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM mydb_test WHERE useremail='" + email + "' AND userpassword ='" + password +"'", null);
                if(cursor.moveToFirst())
                {
                    flag=1;
                    string_fname=cursor.getString(0);
                    string_lname=cursor.getString(1);
                    string_email=cursor.getString(2);
                    string_phone=cursor.getString(3);
                    string_loc=cursor.getString(4);
                    Intent intent_logn = new Intent(Login.this,ProfileActivity.class);
                    startActivity(intent_logn);
                    clearText();

                }
                else
                {
                    showMessage("Failed","Records not found");
                    clearText();

                }
                break;

            case R.id.regbtn:
                Intent intent_reg = new Intent(Login.this,MainActivity.class);
                startActivity(intent_reg);
                finish();
                break;

        }

    }

    private void clearText() {
        editTextemail.setText("");
        editTextpass.setText("");
    }

    private void showMessage(String error, String no_records_found) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(error);
        builder.setMessage(no_records_found);
        builder.setIcon(R.mipmap.my_icon1);
        builder.setCancelable(true);
        builder.show();
    }
}