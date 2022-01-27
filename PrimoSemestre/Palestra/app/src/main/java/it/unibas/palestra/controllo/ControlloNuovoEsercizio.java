package it.unibas.palestra.controllo;

import android.app.Activity;
import android.view.View;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.activity.ActivityNuovoEsercizio;
import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.OperatoreScheda;
import it.unibas.palestra.modello.Scheda;
import it.unibas.palestra.vista.VistaNuovoEsercizio;

public class ControlloNuovoEsercizio {

    private View.OnClickListener azioneSelezionaAttrezzo = new AzioneSelezionaAttrezzo();
    private View.OnClickListener azioneNuovoEsercizio = new AzioneNuovoEsercizio();

    public View.OnClickListener getAzioneNuovoEsercizio() {
        return azioneNuovoEsercizio;
    }

    public View.OnClickListener getAzioneSelezionaAttrezzo() {
        return azioneSelezionaAttrezzo;
    }

    private class AzioneSelezionaAttrezzo implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivityNuovoEsercizio activityNuovoEsercizio = (ActivityNuovoEsercizio) Applicazione.getInstance().getCurrentActivity();
            activityNuovoEsercizio.avviaActivitySelezionaAttrezzo();
        }
    }

    private class AzioneNuovoEsercizio implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            ActivityNuovoEsercizio activityNuovoEsercizio = (ActivityNuovoEsercizio) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoEsercizio vistaNuovoEsercizio = activityNuovoEsercizio.getVistaNuovoEsercizio();
            String stringaPesoInserito = vistaNuovoEsercizio.getPeso();
            String stringaRipetizioniInserite = vistaNuovoEsercizio.getRipetizioni();
            Attrezzo attrezzoSelezinato = (Attrezzo) Applicazione.getInstance().getModello().getBean(Costanti.ATTREZZO_SELEZIONATO);
            //scenari alternativi
            if (erroriPresenti(stringaPesoInserito, stringaRipetizioniInserite, attrezzoSelezinato, vistaNuovoEsercizio)) {
                return;
            }
            Esercizio esercizio = new Esercizio(attrezzoSelezinato, Integer.parseInt(stringaPesoInserito), Integer.parseInt(stringaRipetizioniInserite));
            Scheda schedaSelezionata = (Scheda) Applicazione.getInstance().getModello().getBean(Costanti.SCHEDA_SELEZIONATA);
            OperatoreScheda operatoreScheda = new OperatoreScheda();
            if(operatoreScheda.esercizioGiaPresente(esercizio, schedaSelezionata)) {
                activityNuovoEsercizio.mostraMessaggio("Esercizio già presente, ho proceduto alla modifica");
                vistaNuovoEsercizio.aggiornaListaEsercizi();
                return;
            }
            //scenari alternativi
            schedaSelezionata.aggiungiEsercizio(esercizio);
            vistaNuovoEsercizio.aggiornaListaEsercizi();
        }

        private boolean erroriPresenti(String stringaPesoInserito, String stringaRipetizioniInserite, Attrezzo attrezzoSelezinato, VistaNuovoEsercizio vistaNuovoEsercizio) {
            boolean errori = false;
            if (stringaPesoInserito.isEmpty()) {
                vistaNuovoEsercizio.setErrorePeso("Prima devi inserire un peso");
                errori = true;
            }
            if (stringaRipetizioniInserite.isEmpty()) {
                vistaNuovoEsercizio.setErroreRipetizini("Prima devi inserire un numero di ripetizioni");
                errori = true;
            }
            if (attrezzoSelezinato == null) {
                ActivityNuovoEsercizio activity = (ActivityNuovoEsercizio) Applicazione.getInstance().getCurrentActivity();
                activity.mostraMessaggio("Prima devi selezionare un attrezzo");
            }
            return errori;
        }
    }

}
