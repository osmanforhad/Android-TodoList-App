package developer.osmanforhad.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //__Define variables__//
    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView textView;
    private static final int SPLASH_DURATION = 3300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //__Hide the status bar and make the App Full Screen__//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //__Initiate the Variables and Load the animation file__//
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //__Initiate the Variables and Connect with XML UI Id__//
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.text);

        //__Setup Animation on the Image View__//
        imageView.setAnimation(topAnim);
        //__Setup Animation on the Text View__//
        textView.setAnimation(bottomAnim);

        //__Setup Animation Duration and After Animation go to Next Screen__//
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //__To Go to the Next Screen__//
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);

    }
}