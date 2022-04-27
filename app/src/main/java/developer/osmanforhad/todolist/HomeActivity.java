package developer.osmanforhad.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    //__Define variables__//
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //__Initiate the variables and connect with XML UI Id__//
         toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        //__Setup Toolbar as Actionbar__//
         setSupportActionBar(toolbar);
        //__Setup App Screen Title inside the app actionbar__//
         getSupportActionBar().setTitle("Todo List App");

         //__Setup Linear Layout Manager Object__//
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        //__Setup Recycler View Size__//
        recyclerView.setHasFixedSize(true);
        //__Setup RecyclerView Layout as Linear Layout__//
        recyclerView.setLayoutManager(linearLayoutManager);

        //__Setup Click event in to the Floating Action Button__//
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //__Calling the addTask method__//
                addTask();
            }
        });


    }

    //__Method for to open add task View inside the dialog Interface which already design in the input_file xml__//
    private void addTask() {
        //__Setup a Alert dialog Interface__//
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        //__Inflate the input layout and setup View in the Home Screen__//
        LayoutInflater inflater = LayoutInflater.from(this);
        View myView = inflater.inflate(R.layout.input_file, null);
        //__Pass the view inside the Dialog box__//
        myDialog.setView(myView);
        //__Create a alert Dialog__//
        AlertDialog dialog = myDialog.create();
        //__Setup Cancel functionality__//
        dialog.setCancelable(false);
        //__Display the Dialog box__//
        dialog.show();
    }

}