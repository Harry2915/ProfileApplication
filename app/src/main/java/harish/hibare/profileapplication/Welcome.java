package harish.hibare.profileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class Welcome extends AppCompatActivity {
    Thread timer;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView=findViewById(R.id.giffy);
        Glide.with(this).load(R.drawable.mov).into(imageView);
        timer=new Thread()
        {
            public void run()
            {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent_my = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent_my);
                }
            }
        };
        timer.start();

    }
}