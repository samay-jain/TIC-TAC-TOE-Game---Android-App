package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        final EditText pl1 = findViewById(R.id.player1);
        final EditText pl2 = findViewById(R.id.player2);
        final AppCompatButton playbtn = findViewById(R.id.playbutton);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String pl1name = pl1.getText().toString();
                final String pl2name = pl2.getText().toString();

                if(pl1name.isEmpty() || pl2name.isEmpty())
                {
                    Toast.makeText(addPlayer.this, "Please enter name of Players", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(addPlayer.this, playgame.class);
                    intent.putExtra("pl1name",pl1name);
                    intent.putExtra("pl2name",pl2name);
                    startActivity(intent);
                }
            }
        });

    }
}