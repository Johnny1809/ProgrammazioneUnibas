package it.unibas.palestra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.R;
import it.unibas.palestra.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principale,menu);
        menu.findItem(R.id.menuGeneraNuovaScheda).setOnMenuItemClickListener(Applicazione.getInstance().getControlloMenuPrincipale().getAzioneGeneraScheda());
        return true;
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale) this.getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void avviaActivityAggiungiEsercizio() {
        Intent intent = new Intent(this, ActivityNuovoEsercizio.class);
        startActivity(intent);
    }

    public void avviaActivityGeneraScheda() {
        Intent intent = new Intent(this, ActivityGeneraScheda.class);
        startActivity(intent);
    }

}
