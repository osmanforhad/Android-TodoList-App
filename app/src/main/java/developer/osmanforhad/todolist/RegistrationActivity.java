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

public class RegistrationActivity extends AppCompatActivity {

    //__Define the Variables__//
    private Toolbar toolbar;
    private EditText registerEmail, registerPassword;
    private Button registerButton;
    private TextView registerQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //__Hide the status bar and make the App Full Screen__//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_registration);

        //__Initiate the Variables and Connect With XML UI Id__//
        toolbar = (Toolbar) findViewById(R.id.registrationToolbar);
        registerEmail = (EditText) findViewById(R.id.registrationEmail);
        registerPassword = (EditText) findViewById(R.id.registrationPassword);
        registerButton = (Button) findViewById(R.id.registrationButton);
        registerQuestion = (TextView) findViewById(R.id.registrationPageQuestion);

        //__Setup Toolbar as Actionbar__//
        setSupportActionBar(toolbar);
        //__Setup App Screen Title__//
        getSupportActionBar().setTitle("Registration");

        //__Setup Click Event in to the RegistrationQuestion TextView__//
        registerQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //__Go to the Next Screen__//
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}