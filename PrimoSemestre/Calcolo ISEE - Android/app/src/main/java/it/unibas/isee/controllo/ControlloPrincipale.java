package it.unibas.isee.controllo;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import it.unibas.isee.Applicazione;
import it.unibas.isee.Costanti;
import it.unibas.isee.activity.ActivityPrincipale;
import it.unibas.isee.modello.ModuloIsee;
import it.unibas.isee.modello.StoriaCalcoli;
import it.unibas.isee.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCalcola = new AzioneCalcola();
    private AdapterView.OnItemClickListener azioneSelezioneStoria = new AzioneSelezioneStoria();

    public AdapterView.OnItemClickListener getAzioneSelezioneStoria() {
        return azioneSelezioneStoria;
    }

    public View.OnClickListener getAzioneCalcola (){
        return this.azioneCalcola;
    }

    private  class AzioneSelezioneStoria implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            StoriaCalcoli storiaCalcoli = (StoriaCalcoli) Applicazione.getInstance().getModelloPersistente().getPersistentBean(Costanti.STORIA_CALCOLI, StoriaCalcoli.class);
            ModuloIsee moduloIseeSelezionato = storiaCalcoli.getStoria().get(position);
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            vistaPrincipale.setCampiPrecompilati(moduloIseeSelezionato);
        }
    }

    private class AzioneCalcola implements View.OnClickListener {

        private String TAG = AzioneCalcola.class.getSimpleName();

        @Override
        public void onClick(View v) {
            Log.d(TAG, "Eseguo Azione Calcola");
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            String campoReddito = vistaPrincipale.getCampoReddito();
            String campoPatrimonio = vistaPrincipale.getCampoPatrimonio();
            String campoNumeroComponenti = vistaPrincipale.getCampoNumeroComponenti();
            boolean presenzaMinori = vistaPrincipale.getSwitchMinori();
            boolean errori = convalida(campoReddito, campoPatrimonio, campoNumeroComponenti, presenzaMinori, vistaPrincipale);
            if (errori) {
                return;
            }
            double reddito = Double.parseDouble(campoReddito);
            double patrimonio = Double.parseDouble(campoPatrimonio);
            int numeroComponenti = Integer.parseInt(campoNumeroComponenti);
            ModuloIsee moduloIsee = new ModuloIsee(reddito, patrimonio, numeroComponenti, presenzaMinori);
            StoriaCalcoli storiaCalcoli = (StoriaCalcoli) Applicazione.getInstance().getModelloPersistente().getPersistentBean(Costanti.STORIA_CALCOLI, StoriaCalcoli.class);
            storiaCalcoli.aggiungiCalcolo(moduloIsee);
            String messaggio = "L'isee è di " + moduloIsee.getStringaValoreISEE();
            Log.d(TAG,messaggio);
            activityPrincipale.stampaMessaggio(messaggio);
            vistaPrincipale.aggiornaListaModuli();
        }

        private boolean convalida(String campoReddito, String campoPatrimonio, String campoNumeroComponenti, boolean presenzaMinori, VistaPrincipale vistaPrincipale) {
            boolean errori = false;
            if (campoReddito.trim().isEmpty()) {
                errori = true;
                vistaPrincipale.setErroreReddito("Il campo reddito è obbligatorio");
            } else { //queste verifiche possono essere evitate se l'editText è configurato correttamente
                try {
                    double reddito = Double.parseDouble(campoReddito);
                    if (reddito < 0) {
                        errori = true;
                        vistaPrincipale.setErroreReddito("Il reddito deve essere maggiore di 0");
                    }
                } catch (NumberFormatException e) {
                    errori = true;
                    vistaPrincipale.setErroreReddito("Il campo reddito deve essere un numero");
                }
            }
            if (campoPatrimonio.trim().isEmpty()) {
                errori = true;
                vistaPrincipale.setErrorePatrimonio("Il campo patrimonio è obbligatorio");
            }
            if (campoNumeroComponenti.trim().isEmpty()) {
                errori = true;
                vistaPrincipale.setErroreNumeroComponenti("Il numero di componenti è obbligatorio");
            } else {
                int numeroComponentiIntero = Integer.parseInt(campoNumeroComponenti);
                if (presenzaMinori == true && numeroComponentiIntero < 3) {
                    errori = true;
                    vistaPrincipale.setErroreNumeroComponenti("Il nucleo familiare deve avere almeno tre componenti");
                }
            }
            return errori;
        }
    }

}
