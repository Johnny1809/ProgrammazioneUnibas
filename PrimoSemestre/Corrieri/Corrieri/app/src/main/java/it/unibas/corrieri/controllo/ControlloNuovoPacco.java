package it.unibas.corrieri.controllo;

import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.OperatorePacco;
import it.unibas.corrieri.modello.Utente;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();
    private CalendarView.OnDateChangeListener azioneSelezionaData = new AzioneSelezionaData();
    private View.OnClickListener azioneAggiungiMittente = new AzioneAggiungiUtente(Costanti.MODALITA_SELEZIONE_MITTENTE);
    private View.OnClickListener azioneAggiungiDestinatario = new AzioneAggiungiUtente(Costanti.MODALITA_SELEZIONE_DESTINATARIO);

    public CalendarView.OnDateChangeListener getAzioneSelezionaData() {
        return azioneSelezionaData;
    }

    public View.OnClickListener getAzioneAggiungiDestinatario() {
        return azioneAggiungiDestinatario;
    }

    public View.OnClickListener getAzioneAggiungiMittente() {
        return azioneAggiungiMittente;
    }

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneAggiungiUtente implements View.OnClickListener {

        private String modalita;

        public AzioneAggiungiUtente(String modalita) {
            this.modalita = modalita;
        }

        @Override
        public void onClick(View v) {
            List<Utente> listaUtenti = Applicazione.getInstance().getDaoServer().findAllUtenti();
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_UTENTI, listaUtenti);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            Applicazione.getInstance().getModello().putBean(Costanti.MODALITA_SELEZIONE, modalita);
            activityNuovoPacco.avviaActivitySelezionaUtente();
        }
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Corriere corriereSelezionato = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoPacco vistaNuovoPacco = activityNuovoPacco.getVistaNuovoPacco();
            Calendar dataInvio = (Calendar) Applicazione.getInstance().getModello().getBean(Costanti.DATA_SELEZIONATA);
            String peso = vistaNuovoPacco.getEditTextPeso();
            boolean urgente = vistaNuovoPacco.getCheckBoxUrgente();
            Utente mittente = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.MITTENTE_SELEZIONATO);
            Utente destinatario = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.DESTINATARIO_SELEZIONATO);
            String errori = convalida(dataInvio, peso, urgente, mittente, destinatario);
            if (!errori.isEmpty()) {
                //TODO: testare ancora
                activityNuovoPacco.mostraMessaggioErrore(errori);
                return;
            }
            //effettua la convalida dei dati
            //crea pacco
            //aggiungi il pacco al corriere
            //aggiorna la vista
            //torna all'acitvity precedente
        }

        private String convalida(Calendar dataInvio, String peso, boolean urgente, Utente mittente, Utente destinatario) {
            OperatorePacco operatorePacco = new OperatorePacco();
            StringBuilder errori = new StringBuilder();
            boolean dataValida = true;
            if (dataInvio == null) {
                errori.append("Prima devi selezionare una data");
            } else if (urgente == true && !operatorePacco.verificaDataPaccoUrgente(dataInvio)) {
                errori.append("Data non valida\n");
                dataValida = false;
            }
            if (mittente == null) {
                errori.append("Prima devi selezionare un mittente\n");
            }
            if (destinatario == null) {
                errori.append("Prima devi selezionare un destinatario\n");
            }
            if (peso.trim().isEmpty()) {
                errori.append("Prima devi inserire un peso\n");
            }
            if (mittente != null && destinatario != null && mittente.getCodice().trim().equalsIgnoreCase(destinatario.getCodice().trim())) {
                errori.append("Mittente e destinatario devono essere persone diverse\n");
            }
            if (mittente != null && destinatario != null  && !peso.trim().isEmpty() && dataValida &&
                    operatorePacco.verificaResoValido(destinatario, mittente, dataInvio, Double.parseDouble(peso))) {
                errori.append("Il pacco è un reso, ed il suo peso non è valido\n");
            }
            return errori.toString().trim();
        }
    }

    private class AzioneSelezionaData implements CalendarView.OnDateChangeListener {

        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Calendar dataSelezionata = new GregorianCalendar(year, month, dayOfMonth);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA, dataSelezionata);
        }

    }
}
