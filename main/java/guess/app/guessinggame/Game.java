package guess.app.guessinggame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.lang.*;

public class Game extends AppCompatActivity {


    ImageButton btnSubmit;
    EditText numberOfTries,answer,response;
    private int iNumberOfTries;
    private int guessedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        guessedNumber = (int)(Math.random()*100);
        answer = (EditText) findViewById(R.id.txtAnswerPad);
        response = (EditText) findViewById(R.id.txtResponse);
        numberOfTries = (EditText) findViewById(R.id.txtNumberOfTries);
        iNumberOfTries = 5;
        //btnSubmit = (ImageButton)findViewById(R.id.btnSubmit);
        }


    protected void btnSubmit()throws NumberFormatException {
        int input = Integer.parseInt(answer.getText().toString());
        int iComparison = (Integer.toString(input)).compareToIgnoreCase(Integer.toString(guessedNumber));
        do {
            switch (iComparison) {
                case 0:
                    response.setText("You Win!!!!!", TextView.BufferType.NORMAL);
                    response.setTextColor(Color.GREEN);
                    break;
                case 1:
                    response.setText("Too High!!!!!", TextView.BufferType.NORMAL);
                    response.setTextColor(Color.RED);
                    answer.setText("",TextView.BufferType.NORMAL);
                    iNumberOfTries--;
                    break;
                case -1:
                    response.setText("Too Low!!!!!", TextView.BufferType.NORMAL);
                    response.setTextColor(Color.BLUE);
                    iNumberOfTries--;
                    break;
                default:
                    response.setText("I don't think that will work", TextView.BufferType.NORMAL);
                    response.setTextColor(Color.BLACK);
                    answer.setText("",TextView.BufferType.NORMAL);
            }
            numberOfTries.setText(String.format("# of tries left: {0}",iNumberOfTries),TextView.BufferType.NORMAL);
            response.setVisibility(View.VISIBLE);
        }
        while (iNumberOfTries>0);

    }
    }

