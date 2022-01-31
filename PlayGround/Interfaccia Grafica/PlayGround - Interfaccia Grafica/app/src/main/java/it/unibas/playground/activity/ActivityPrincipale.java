package it.unibas.playground.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.unibas.playground.Costanti;
import it.unibas.playground.R;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    public void lanciaActivitySelezioneFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        //si potrebbe fare il setting del MIME Type richiesto
        intent.setType("text/plain");
        try {
            this.startActivityForResult(intent, Costanti.CODICE_SELEZIONA_FILE);
        } catch (ActivityNotFoundException ex) {
            mostraMessaggio("Installa un file manager");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //in base al codice richiesta decido cosa fare. il result code ok mi dice che è andata a buon fine,
        // mi assicuro che i dati non siano null (se l'utente esce senza selezionare quanto richiesto data viene restituito null)
        if (requestCode == Costanti.CODICE_SELEZIONA_FILE && resultCode == Activity.RESULT_OK && data == null) {
            Uri fileSelezionato = data.getData();
            mostraMessaggio(fileSelezionato.getPath());
        } else {
            mostraMessaggio("File non selezionato (o ci sono stati dei problemi)");
        }
    }

    public void mostraMessaggio(String messaggio) {
        Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
    }
}
