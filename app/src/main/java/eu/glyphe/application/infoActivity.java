package eu.glyphe.application;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class infoActivity extends AppCompatActivity {

    private TextView titre;
    private TextView texte;
    private TextView jour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        this.titre = (TextView) this.findViewById(R.id.titre);
        this.texte = (TextView) this.findViewById(R.id.texte);
        this.jour = (TextView) this.findViewById(R.id.jour);

        //reglage font
        Typeface typeface = Typeface.createFromAsset(getAssets(),"DaxWidLig.ttf");
        this.titre.setTypeface(typeface);
        this.titre.setTextSize(40);
        this.texte.setTextSize(25);
        this.jour.setTextSize(16);

        //recuperation de l'id + text + mise a jour textview
        Intent intent = this.getIntent();
        int idjoueur  = 0;
        switch (intent.getIntExtra("NAME", 0)){
            case R.id.federer:
                this.titre.setText("R. Federer");
                idjoueur = R.string.federer;
                this.jour.setText("vendredi 25 mai 2014");
                break;

            case R.id.nadal:
                this.titre.setText("R. Nadal");
                idjoueur = R.string.nadal;
                break;

            case R.id.schiavone:
                this.titre.setText("A. schiavone");
                idjoueur = R.string.schiavone;
                break;
        }
        this.texte.setText(Html.fromHtml(getResources().getString(idjoueur)));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Calendar c = Calendar.getInstance();
        String jr = "";
        if(c.get(Calendar.DAY_OF_MONTH )< 10){jr = "0";}
        jr += c.get(Calendar.DAY_OF_MONTH);
        String mois = "";
        if (c.get(Calendar.MONTH)<10){mois = "0";}
        mois += c.get(Calendar.MONTH);
        String annee = "";
        annee += c.get(Calendar.YEAR);

        this.jour.setText(jr + "/" + mois + "/" + annee);
    }
}
