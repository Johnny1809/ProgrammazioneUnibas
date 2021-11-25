package it.unibas.isee.controllo;

import android.util.Log;
import android.view.View;

import it.unibas.isee.Applicazione;
import it.unibas.isee.activity.ActivityPrincipale;
import it.unibas.isee.modello.ModuloIsee;
import it.unibas.isee.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCalcola = new AzioneCalcola();

    public View.OnClickListener getAzioneCalcola (){
        return this.azioneCalcola;
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
            String messaggio = "L'isee è di " + moduloIsee.getStringaValoreISEE();
            Log.d(TAG,messaggio);
            activityPrincipale.stampaMessaggio(messaggio);
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
