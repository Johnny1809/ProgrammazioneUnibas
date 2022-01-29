package it.unibas.trasferimenti.controllo;

import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.GregorianCalendar;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.activity.ActivitNuovoTrasferimento;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.modello.Trasferimento;
import it.unibas.trasferimenti.vista.VistaNuovoTrasferimento;

public class ControlloNuovoTrasferimento {

    private CalendarView.OnDateChangeListener azioneSelezionaData = new AzioneSelezionaData();
    private View.OnClickListener azioneNuovoTrasferimento = new AzioneNuovoTrasferimento();

    public CalendarView.OnDateChangeListener getAzioneSelezionaData() {
        return azioneSelezionaData;
    }

    public View.OnClickListener getAzioneNuovoTrasferimento() {
        return azioneNuovoTrasferimento;
    }

    private class AzioneNuovoTrasferimento implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivitNuovoTrasferimento activitNuovoTrasferimento = (ActivitNuovoTrasferimento) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoTrasferimento vistaNuovoTrasferimento = activitNuovoTrasferimento.getVistaNuovoTrasferimento();
            Calendar dataSelezionata = (Calendar) Applicazione.getInstance().getModello().getBean(Costanti.DATA_SELEZIONATA_NUOVO_TRASFERIMENTO);
            String squadraDa = vistaNuovoTrasferimento.getSquadraDa();
            String squadraA = vistaNuovoTrasferimento.getSquadraA();
            String costo = vistaNuovoTrasferimento.getCosto();
            boolean errori = valutaErrori(activitNuovoTrasferimento, vistaNuovoTrasferimento, dataSelezionata, squadraDa, squadraA, costo);
            if (errori) {
                return;
            }
            Trasferimento t = new Trasferimento(dataSelezionata, squadraDa, squadraA, Integer.parseInt(costo));
            Calciatore calciatoreSelezionato = (Calciatore) Applicazione.getInstance().getModello().getBean(Costanti.CALCIATORE_SELEZIONATO);
            calciatoreSelezionato.aggiungiTrasferimento(t);
            activitNuovoTrasferimento.finish();
        }

        private boolean valutaErrori(ActivitNuovoTrasferimento activitNuovoTrasferimento, VistaNuovoTrasferimento vistaNuovoTrasferimento, Calendar dataSelezionata, String squadraDa, String squadraA, String costo) {
            boolean errori = false;
            if (dataSelezionata ==  null) {
                activitNuovoTrasferimento.mostraMessaggio("Prima devi selezionare una data");
                errori = true;
            }
            if (squadraDa.trim().isEmpty()) {
                vistaNuovoTrasferimento.setErroreDa("Inserisci una squadra");
                errori = true;
            }
            if (squadraA.trim().isEmpty()) {
                vistaNuovoTrasferimento.setErroreA("Inserisci una squadra");
                errori = true;
            }
            if (costo.trim().isEmpty()) {
                vistaNuovoTrasferimento.setErroreCosto("Inserisci una squadra");
                errori = true;
            }
            return errori;
        }
    }

    private class AzioneSelezionaData implements CalendarView.OnDateChangeListener {

        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA_NUOVO_TRASFERIMENTO, calendar);
        }
    }
}
