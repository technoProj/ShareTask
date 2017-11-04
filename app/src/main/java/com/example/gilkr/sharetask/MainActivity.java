package com.example.gilkr.sharetask;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.support.design.widget.FloatingActionButton;
import android.widget.ListView;

import com.parse.ParseObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    FloatingActionButton addButton ;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject.registerSubclass(User.class);

        Intent logInIntent = new Intent(this, LogInActivity.class);
        startActivity(logInIntent);

        mTaskListView = (ListView) findViewById(R.id.list_todo);
        addButton = (FloatingActionButton) findViewById(R.id.addTaskButton);
        final ArrayList<String> taskList = new ArrayList<>(); //TODO : one you use database change this list behaviour
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText taskEditText = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                taskList.add(task);
                                if (mAdapter == null) {
                                    mAdapter = new ArrayAdapter<>(MainActivity.this,
                                            R.layout.item_todo,
                                            R.id.task_title,
                                            taskList);
                                    mTaskListView.setAdapter(mAdapter);
                                } else {
                                    //mAdapter.clear();
                                    //mAdapter.addAll(taskList);
                                    mAdapter.notifyDataSetChanged();
                                }
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });

    }
}
