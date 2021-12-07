package it.unibas.corrieri.controllo;

import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Corriere corriereSelezionato = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
            //preleva dataInvio, peso, urgente, mittente, destinatario dalla vistaNuovoPacco
            //effettua la convalida dei dati
            //crea pacco
            //aggiungi il pacco al corriere
            //aggiorna la vista
            //torna all'acitvity precedente
        }
    }
}
