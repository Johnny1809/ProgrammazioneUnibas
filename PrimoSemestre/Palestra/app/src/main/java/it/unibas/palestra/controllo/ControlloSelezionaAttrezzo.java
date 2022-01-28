package it.unibas.palestra.controllo;

import android.view.View;
import android.widget.AdapterView;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.activity.ActivitySelezionaAttrezzo;
import it.unibas.palestra.modello.Attrezzo;

public class ControlloSelezionaAttrezzo {

    private AdapterView.OnItemClickListener azioneAttrezzoSelezionato = new AzioneAttrezzoSelezionato();

    public AdapterView.OnItemClickListener getAzioneAttrezzoSelezionato() {
        return azioneAttrezzoSelezionato;
    }

    private class AzioneAttrezzoSelezionato implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivitySelezionaAttrezzo activitySelezionaAttrezzo = (ActivitySelezionaAttrezzo) Applicazione.getInstance().getCurrentActivity();
            Attrezzo attrezzo = (Attrezzo) activitySelezionaAttrezzo.getVistaSelezionaAttrezzo().getListViewAttrezzi().getItemAtPosition(position);
            Applicazione.getInstance().getModello().putBean(Costanti.ATTREZZO_SELEZIONATO, attrezzo);
            activitySelezionaAttrezzo.mostraMessaggio("Attrezzo inserito");
            activitySelezionaAttrezzo.finisciActivity();
        }
    }

}
