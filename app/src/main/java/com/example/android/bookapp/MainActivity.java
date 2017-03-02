package com.example.android.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
    }

    /**
     * This method is to call.
     * the text field
     */
    public void bookSearch(View view) {

        Intent i = new Intent (this, BookActivity.class);

        final EditText bookSearchInput = (EditText) findViewById(R.id.search_box);
        String userMessage = bookSearchInput.getText().toString();
        i.putExtra("", userMessage);

        startActivity(i);

        EditText nameField = (EditText) findViewById(R.id.search_box);
        String searchBook = nameField.getText().toString();
        Toast.makeText(this, "the button is working", Toast.LENGTH_SHORT).show();
    }
}