package developer.osmanforhad.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    //__Define the Variables__//
    private Toolbar toolbar;
    private EditText registerEmail, registerPassword;
    private Button registerButton;
    private TextView registerQuestion;
    private FirebaseAuth mAuth;
    private ProgressDialog loader;

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
        mAuth = (FirebaseAuth) FirebaseAuth.getInstance();
        loader = (ProgressDialog) new ProgressDialog(this);

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

        //__Setup Click Event in to the Register Button__//
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //__Get User input and Convert to String with trim those input__//
                String email = registerEmail.getText().toString().trim();
                String password = registerPassword.getText().toString().trim();

                //__Validation Setup__//
                if(TextUtils.isEmpty(email)){
                    registerEmail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    registerEmail.setError("password is required");
                    return;
                }
                else {
                    //__Setup Progress Dialog bar__//
                    loader.setMessage("Registration in progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();

                    //__setup User register functionality__//
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                //__GO to Next Screen__//
                                Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                                //__Cancel the Loader Dialog__//
                                loader.dismiss();
                            }
                            else {
                                //__Catch Error Exception__//
                                String error = task.getException().toString();
                                //__show Error Message__??
                                Toast.makeText(RegistrationActivity.this, "Registration failed" + error, Toast.LENGTH_SHORT).show();
                                //__Cancel the Loader Dialog__//
                                loader.dismiss();
                            }

                        }
                    });
                }

            }
        });

    }
}