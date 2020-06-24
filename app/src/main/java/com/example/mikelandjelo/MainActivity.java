package com.example.mikelandjelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ja.burhanrashid52.photoeditor.PhotoEditorView;

public class MainActivity extends AppCompatActivity {

    private PhotoEditorView photoEditorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoEditorView = findViewById(R.id.photoEditorView);

        photoEditorView.getSource().setImageResource(R.drawable.back);
    }
}