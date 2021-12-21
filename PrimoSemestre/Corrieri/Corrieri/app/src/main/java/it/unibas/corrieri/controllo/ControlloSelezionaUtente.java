package it.unibas.corrieri.controllo;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivitySelezionaUtente;
import it.unibas.corrieri.modello.Utente;

public class ControlloSelezionaUtente {

    private AdapterView.OnItemClickListener azioneUtenteSelezionato = new AzioneUtenteSelezionato();

    public AdapterView.OnItemClickListener getAzioneUtenteSelezionato() {
        return azioneUtenteSelezionato;
    }

    private class AzioneUtenteSelezionato implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivitySelezionaUtente activitySelezionaUtente = (ActivitySelezionaUtente) Applicazione.getInstance().getCurrentActivity();
            List<Utente> listaUtenti = (List<Utente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_UTENTI);
            Utente utenteSelezionato = listaUtenti.get(position);
            String modalitaSelezione = (String) Applicazione.getInstance().getModello().getBean(Costanti.MODALITA_SELEZIONE);
            Log.d(ControlloSelezionaUtente.class.getSimpleName(), "Sto gestendo un tap su un elemento della lista utenti...");
            if(modalitaSelezione.equalsIgnoreCase(Costanti.MODALITA_SELEZIONE_MITTENTE)) {
                Applicazione.getInstance().getModello().putBean(Costanti.MITTENTE_SELEZIONATO, utenteSelezionato);
                activitySelezionaUtente.finish();
                return;
            } else if (modalitaSelezione.equalsIgnoreCase(Costanti.MODALITA_SELEZIONE_DESTINATARIO)) {
                Applicazione.getInstance().getModello().putBean(Costanti.DESTINATARIO_SELEZIONATO, utenteSelezionato);
                activitySelezionaUtente.finish();
                return;
            }
            throw new RuntimeException("In qualche modo lo user ha selezionato un utente senza prima specificare " +
                    "se fosse mittente o destinatario");
        }
    }

}
