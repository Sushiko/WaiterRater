// Abe Choi - Tip Calculator

package com.example.sushiko.waiterrater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.NumberPicker;
import java.text.DecimalFormat;

import static com.example.sushiko.waiterrater.R.id.et_input;
import static com.example.sushiko.waiterrater.R.id.np_rating;
import static com.example.sushiko.waiterrater.R.id.tv_output;

public class MainActivity extends AppCompatActivity {

    private TextView outputTextView;
    private EditText inputEditText;
    private Button enterButton;
    private NumberPicker np;
    public double cost;

    DecimalFormat fm = new DecimalFormat("$#,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create some references
        this.outputTextView = (TextView) findViewById(tv_output);
        this.inputEditText = (EditText) findViewById(et_input);
        this.enterButton = (Button) findViewById(R.id.btn_enter);
        this.np = (NumberPicker) findViewById(np_rating);

        np.setMinValue(1);
        np.setMaxValue(10);

        this.enterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // Turn input into a string then into variable cost as a float
                String myStr = inputEditText.getText().toString();

                try{
                    cost = Float.parseFloat(myStr);
                }catch (Exception e){
                    cost=0;
                }

                int rating = np.getValue();
                double tip = 0.00;

                if(rating > 0 && rating < 4){
                    tip = cost*.1;
                }
                else if(rating > 3 && rating < 6){
                    tip = cost*.13;
                }
                else if(rating > 5 && rating < 8){
                    tip = cost*.15;
                }
                else if(rating > 7 && rating < 10){
                    tip = cost*.2;
                }
                else if(rating == 10){
                    tip = cost*.25;
                }

                // output message
                myStr = "Your bill was "+fm.format(cost);
                myStr = myStr + "\nand you rated your service "+rating+"/10.";
                myStr = myStr + "\nYou should tip "+fm.format(tip)+".";

                if(cost < 1 || cost > 100000){
                    outputTextView.setText("Error: Please enter a value from 1 to 100,000");
                }
                else
                    outputTextView.setText(myStr);
            }
        });
    }
}
