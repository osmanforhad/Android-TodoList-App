package developer.osmanforhad.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    //__Define the Variables__//
    private Toolbar toolbar;
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private TextView loginQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //__Hide the status bar and make the App Full Screen__//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        //__Initiate the Variables and Connect With XML UI Id__//
        toolbar = (Toolbar) findViewById(R.id.loginToolbar);
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginQuestion = (TextView) findViewById(R.id.loginPageQuestion);

        //__Setup Toolbar as Actionbar__//
        setSupportActionBar(toolbar);
        //__Setup App Screen Title__//
        getSupportActionBar().setTitle("Login");

        //__Setup Click Event in to the loginQuestion TextView__//
        loginQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //__Go to the Next Screen__//
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}