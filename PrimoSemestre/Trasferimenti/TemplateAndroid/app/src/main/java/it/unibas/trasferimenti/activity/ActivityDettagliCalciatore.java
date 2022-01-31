package it.unibas.trasferimenti.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.vista.VistaPrincipale;

public class ActivityDettagliCalciatore extends AppCompatActivity {

    public static final String TAG = ActivityDettagliCalciatore.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettagli_calciatore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dettagli_calciatore, menu);
        MenuItem voceMenuNuovo = menu.findItem(R.id.voceMenuNuovo);
        voceMenuNuovo.setOnMenuItemClickListener(Applicazione.getInstance().getControlloDettagliCalciatore().getAzioneNuovoTrasferimento());
        return super.onCreateOptionsMenu(menu);
    }

    public void avviaActivityNuovoTrasferimento() {
        Intent intent = new Intent(this, ActivitNuovoTrasferimento.class);
        startActivity(intent);
    }
}
