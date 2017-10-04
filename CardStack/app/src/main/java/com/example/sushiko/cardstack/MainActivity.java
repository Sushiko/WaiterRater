package com.example.sushiko.cardstack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

import java.util.Collections;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {

    // Private declartions
    private TextView topNum, botNum;
    private ImageView topIcon, botIcon, mainIcon;
    private Card card;
    private Stack<Card> cardStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarations
        this.topNum = (TextView) findViewById(R.id.tv_topNum);
        this.botNum = (TextView) findViewById(R.id.tv_botNum);
        this.topIcon = (ImageView) findViewById(R.id.iv_topIcon);
        this.botIcon = (ImageView) findViewById(R.id.iv_botIcon);
        this.mainIcon = (ImageView) findViewById(R.id.iv_mainIcon);

        // Build deck
        for (int i = 2; i < 15; ++i) {

            card = new Card(i, Suits.DIAMONDS);
            cardStack.push(card);
            card = new Card(i, Suits.CLOVERS);
            cardStack.push(card);
            card = new Card(i, Suits.HEARTS);
            cardStack.push(card);
            card = new Card(i, Suits.SPADES);
            cardStack.push(card);
        }

        // Shuffle Deck
        Collections.shuffle(cardStack);
    }

    // Generates card with a Card object
    private void genCard(Card card){

        // gets enum Suits from card object
        switch(card.getSuit()){

            case HEARTS:
                mainIcon.setImageResource(R.drawable.hearts);
                topIcon.setImageResource(R.drawable.hearts);
                botIcon.setImageResource(R.drawable.hearts);
                topNum.setTextColor(Color.RED);
                botNum.setTextColor(Color.RED);
                break;

            case CLOVERS:
                mainIcon.setImageResource(R.drawable.clubs);
                topIcon.setImageResource(R.drawable.clubs);
                botIcon.setImageResource(R.drawable.clubs);
                topNum.setTextColor(Color.BLACK);
                botNum.setTextColor(Color.BLACK);
                break;

            case DIAMONDS:
                mainIcon.setImageResource(R.drawable.diamonds);
                topIcon.setImageResource(R.drawable.diamonds);
                botIcon.setImageResource(R.drawable.diamonds);
                topNum.setTextColor(Color.RED);
                botNum.setTextColor(Color.RED);
                break;

            case SPADES:
                mainIcon.setImageResource(R.drawable.spades);
                topIcon.setImageResource(R.drawable.spades);
                botIcon.setImageResource(R.drawable.spades);
                topNum.setTextColor(Color.BLACK);
                botNum.setTextColor(Color.BLACK);
                break;
        }

        // Gets the number 2-14; 11,12,13,14 are translated to J,Q,K,A
        switch (card.getNumber()){
            case 2:
                topNum.setText(R.string.two);
                botNum.setText(R.string.two); break;
            case 3:
                topNum.setText(R.string.three);
                botNum.setText(R.string.three); break;
            case 4:
                topNum.setText(R.string.four);
                botNum.setText(R.string.four); break;
            case 5:
                topNum.setText(R.string.five);
                botNum.setText(R.string.five); break;
            case 6:
                topNum.setText(R.string.six);
                botNum.setText(R.string.six); break;
            case 7:
                topNum.setText(R.string.seven);
                botNum.setText(R.string.seven); break;
            case 8:
                topNum.setText(R.string.eight);
                botNum.setText(R.string.eight); break;
            case 9:
                topNum.setText(R.string.nine);
                botNum.setText(R.string.nine); break;
            case 10:
                topNum.setText(R.string.ten);
                botNum.setText(R.string.ten); break;
            case 11:
                topNum.setText(R.string.j);
                botNum.setText(R.string.j); break;
            case 12:
                topNum.setText(R.string.q);
                botNum.setText(R.string.q); break;
            case 13:
                topNum.setText(R.string.k);
                botNum.setText(R.string.k); break;
            case 14:
                topNum.setText(R.string.a);
                botNum.setText(R.string.a); break;
        }
    }

    // Clicking on the screen generates a new card, unless there are no more cards
    public void onClickScreen(View view) {
        if(!cardStack.empty()){
            card = cardStack.pop();
            genCard(card);
        }
        else
            finish();
    }

}
