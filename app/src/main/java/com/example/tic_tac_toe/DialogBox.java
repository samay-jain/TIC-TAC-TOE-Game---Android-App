package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DialogBox extends Dialog
{
    private final String message;
    private final playgame play;

    public DialogBox(@NonNull Context context,String message,playgame play) {
        super(context);
        this.message=message;
        this.play=play;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.windialog);
        final TextView showwinner = findViewById(R.id.showwinner);
        final Button playagain = findViewById(R.id.startagain);
        showwinner.setText(message);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.restartMatch();
                dismiss();
            }
        });
    }
}

