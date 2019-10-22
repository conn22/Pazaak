package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button run_test = (Button) findViewById(R.id.run_test);

        myText = (EditText) findViewById(R.id.test_text);

        run_test.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        this.myText.setText("");

        PazaakGameState firstInstance = new PazaakGameState();
        PazaakGameState secondInstance = new PazaakGameState(firstInstance);

        firstInstance.setPlayer(1);
        secondInstance.setPlayer(0);

        firstInstance.playCard(firstInstance.getPlayer(), firstInstance.getPlayer1side()[2]);
        myText.append("Player 1 played card 2 from side hand.\n");

        firstInstance.endTurn(firstInstance.getNextPlayer());
        myText.append("Player 2 ends turn.\n");

        firstInstance.stand(firstInstance.getNextPlayer());
        myText.append("Player 1 stands.\n");

        PazaakGameState thirdInstance = new PazaakGameState();

        PazaakGameState fourthInstance = new PazaakGameState(thirdInstance);
        fourthInstance.setPlayer(0);

        myText.append(secondInstance.toString());
        myText.append("\n\n");
        myText.append(fourthInstance.toString());


    }

}
