package it.unibas.palestra.controllo;

import android.app.Activity;
import android.graphics.Path;
import android.view.View;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.activity.ActivityGeneraScheda;
import it.unibas.palestra.modello.OperatoreScheda;
import it.unibas.palestra.modello.Scheda;
import it.unibas.palestra.vista.VistaGeneraScheda;

public class ControlloGeneraScheda {

    private View.OnClickListener azioneGeneraScheda = new AzioneGeneraScheda();

    public View.OnClickListener getAzioneGeneraScheda() {
        return azioneGeneraScheda;
    }

    private class AzioneGeneraScheda implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivityGeneraScheda activityGeneraScheda = (ActivityGeneraScheda) Applicazione.getInstance().getCurrentActivity();
            VistaGeneraScheda vistaGeneraScheda = activityGeneraScheda.getVistaGeneraScheda();
            String codiceFiscale = vistaGeneraScheda.getCodiceFiscale();
            String nome = vistaGeneraScheda.getCampoNome();
            String stringaDifficolta = vistaGeneraScheda.getCampoDifficolta();
            if (erroriCompiuti(stringaDifficolta, vistaGeneraScheda)) {
                return;
            }
            int difficolta = Integer.parseInt(stringaDifficolta);
            OperatoreScheda operatoreScheda = new OperatoreScheda();
            if (Applicazione.getInstance().getDaoServer().findSchedaByDifficolta(difficolta).isEmpty()) {
                return;
            }
            Scheda scheda = operatoreScheda.generaScheda(codiceFiscale, nome, difficolta,Applicazione.getInstance().getDaoServer().findSchedaByDifficolta(difficolta));
            Applicazione.getInstance().getDaoServer().updateListaSchede(scheda);
            List<Scheda> listaSchedeMostrata = (List<Scheda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_SCHEDE_MOSTRATA);
            Scheda elementoListaMostrata = null;
            if (listaSchedeMostrata != null && !listaSchedeMostrata.isEmpty()) {
                elementoListaMostrata = listaSchedeMostrata.get(0);
            }
            if (elementoListaMostrata != null && elementoListaMostrata.getDifficolta() == scheda.getDifficolta()) {
                listaSchedeMostrata.add(scheda);
            }
        }

        private boolean erroriCompiuti(String stringaDifficolta, VistaGeneraScheda vistaGeneraScheda) {
            boolean erroriCompiuti = false;
            if(stringaDifficolta.isEmpty()) {
                vistaGeneraScheda.setErroreCampoDifficolta("Prima devi inserire una difficolta");
                erroriCompiuti = true;
            } else {
                int difficolta = Integer.parseInt(stringaDifficolta);
                if(difficolta < 1 || difficolta > 5) {
                    vistaGeneraScheda.setErroreCampoDifficolta("Inserisci un valore di difficolta valido");
                    erroriCompiuti = true;
                }
            }
            return erroriCompiuti;
        }
    }

}
