package com.example.tic_tac_toe;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class playgame extends AppCompatActivity
{

    private final List<int[]>combinations = new ArrayList<>();
    private int boxpositions[] = {0,0,0,0,0,0,0,0,0};
    private int playerturn=1;
    private int totalselectedboxes=1;
    private LinearLayout pl1layout,pl2layout;
    private TextView pl1name,pl2name;
    private ImageView im1,im2,im3,im4,im5,im6,im7,im8,im9;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);

        pl1name = findViewById(R.id.playerone);
        pl2name = findViewById(R.id.playertwo);
        pl1layout = findViewById(R.id.Playeronelayout);
        pl2layout = findViewById(R.id.Playertwolayout);

        im1 = findViewById(R.id.but1);
        im2 = findViewById(R.id.but2);
        im3 = findViewById(R.id.but3);
        im4 = findViewById(R.id.but4);
        im5 = findViewById(R.id.but5);
        im6 = findViewById(R.id.but6);
        im7 = findViewById(R.id.but7);
        im8 = findViewById(R.id.but8);
        im9 = findViewById(R.id.but9);


        combinations.add(new int[]{0,1,2});
        combinations.add(new int[]{3,4,5});
        combinations.add(new int[]{6,7,8});
        combinations.add(new int[]{0,3,6});
        combinations.add(new int[]{1,4,7});
        combinations.add(new int[]{2,5,8});
        combinations.add(new int[]{0,4,8});
        combinations.add(new int[]{2,4,6});

        final String playeronename = getIntent().getStringExtra("pl1name");
        final String playertwoname = getIntent().getStringExtra("pl2name");

        pl1name.setText(playeronename);
        pl2name.setText(playertwoname);


        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(0))
                {
                    doAction((ImageView)view,0);
                }
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(1))
                {
                    doAction((ImageView)view,1);
                }

            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(2))
                {
                    doAction((ImageView)view,2);
                }

            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(3))
                {
                    doAction((ImageView)view,3);
                }

            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(4))
                {
                    doAction((ImageView)view,4);
                }

            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(5))
                {
                    doAction((ImageView)view,5);
                }

            }
        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(6))
                {
                    doAction((ImageView)view,6);
                }

            }
        });

        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(7))
                {
                    doAction((ImageView)view,7);
                }

            }
        });

        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxalreadySelected(8))
                {
                    doAction((ImageView)view,8);
                }
            }
        });
    }



    private void doAction(ImageView imageView,int selectedboxpositions)
    {
        boxpositions[selectedboxpositions]=playerturn;
        if(playerturn==1)
        {
            imageView.setImageResource(R.drawable.crosssym);
            if(checkforWin())
            {
                DialogBox dialogbox = new DialogBox(playgame.this,pl1name.getText().toString()+" has won the match",playgame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
            }
            else if(totalselectedboxes==9)
            {
                DialogBox dialogbox = new DialogBox(playgame.this,"Match Draw!!!",playgame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
            }
            else
            {
                changePlayerTurn(2);
                totalselectedboxes+=1;
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.osym);
            if(checkforWin())
            {
                DialogBox dialogbox = new DialogBox(playgame.this,pl2name.getText().toString()+" has won the match",playgame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
            }
            else if(selectedboxpositions==9)
            {
                DialogBox dialogbox = new DialogBox(playgame.this,"Match Draw!!!",playgame.this);
                dialogbox.setCancelable(false);
                dialogbox.show();
            }
            else
            {
                changePlayerTurn(1);
                totalselectedboxes+=1;
            }
        }
    }
    private void changePlayerTurn(int currentplayerturn)
    {
        playerturn=currentplayerturn;
        if(playerturn==1)
        {
            pl1layout.setBackgroundResource(R.drawable.xolayout);
            pl2layout.setBackgroundResource(R.drawable.blueroundcorner);
        }
        else
        {
            pl1layout.setBackgroundResource(R.drawable.blueroundcorner);
            pl2layout.setBackgroundResource(R.drawable.xolayout);
        }
    }
    private boolean checkforWin()
    {
        boolean resp=false;
        for(int i=0;i<combinations.size();i++)
        {
            final int[] combination = combinations.get(i);
            if(boxpositions[combination[0]]==playerturn && boxpositions[combination[1]]==playerturn && boxpositions[combination[2]]==playerturn)
            {
                resp=true;
            }
        }
        return resp;
    }
    private boolean isboxalreadySelected(int boxposition)
    {
        boolean resp=false;
        if(boxpositions[boxposition]==0)
            resp=true;
        return resp;
    }
    public void restartMatch()
    {
        boxpositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerturn=1;
        totalselectedboxes=1;
        im1.setImageResource(R.drawable.blueroundcorner);
        im2.setImageResource(R.drawable.blueroundcorner);
        im3.setImageResource(R.drawable.blueroundcorner);
        im4.setImageResource(R.drawable.blueroundcorner);
        im5.setImageResource(R.drawable.blueroundcorner);
        im6.setImageResource(R.drawable.blueroundcorner);
        im7.setImageResource(R.drawable.blueroundcorner);
        im8.setImageResource(R.drawable.blueroundcorner);
        im9.setImageResource(R.drawable.blueroundcorner);
    }
}