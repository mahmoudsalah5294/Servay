package com.mahmoudsalah.servay;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView questionText;
    Button yesbutton;
    Button nobutton;
    Button startbutton;
    TextView question2Text;
    byte yes,no,i;
    String[] lan = {"Arabic","English","Franch","Deutsh"};
    MediaPlayer player1,player2;
    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText=findViewById(R.id.questionText);
        yesbutton=findViewById(R.id.yesbutton);
        nobutton=findViewById(R.id.nobutton);
        player1 = MediaPlayer.create(this,R.raw.yes);
        player2 = MediaPlayer.create(this,R.raw.no);

        yesbutton.setEnabled(false);
        nobutton.setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player1.stop();
        player2.stop();
    }

    public void start(View view) {
        i=0;
        yes=0;
        no=0;
        questionText.setText("Do you speak "+lan[0]);
        yesbutton.setEnabled(true);
        nobutton.setEnabled(true);

    }
    public void yes(View view) {
        if (yesbutton.getText().toString().equals("yes")) {
            yes++;


            i++;
            if (i < 4) {
                questionText.setText("Do you speak " + lan[i]);


            }
        }
        else{
            no++;
            i++;
            if (i<4) {
                questionText.setText("Do you speak " + lan[i]);
        }
        }
        if (!(i%2==0)) {
            yesbutton.setText("no");
            nobutton.setText("yes");
        }
        else{
            yesbutton.setText("yes");
            nobutton.setText("no");
        }
        if (i == 4) {
            Toast.makeText(this, "The number of yes = " + yes, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "The number of No = " + no, Toast.LENGTH_LONG).show();
            yesbutton.setEnabled(false);
            nobutton.setEnabled(false);
            if (yes>=3){
                player1.start();
            }
            else
                player2.start();
        }
    }

    public void no(View view) {
            if (nobutton.getText().toString().equals("no")) {
                no++;
                i++;
                if (i < 4) {
                    questionText.setText("Do you speak " + lan[i]);
                }
            }
            else{
                yes++;
                i++;
                if (i<4) {
                    questionText.setText("Do you speak " + lan[i]);
            }
        }
        if (!(i%2==0)) {
            yesbutton.setText("no");
            nobutton.setText("yes");
        }
        else{
            yesbutton.setText("yes");
            nobutton.setText("no");
        }
        if (i == 4) {
            Toast.makeText(this, "The number of yes = " + yes, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "The number of No = " + no, Toast.LENGTH_LONG).show();
            yesbutton.setEnabled(false);
            nobutton.setEnabled(false);
            if (yes>=3){
                player1.start();
            }
            else
                player2.start();
        }
    }


}
