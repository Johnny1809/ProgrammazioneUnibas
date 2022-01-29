package it.unibas.trasferimenti.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.modello.Trasferimento;

public class VistaNuovoTrasferimento extends Fragment {

    CalendarView calendarioSceltaData;
    EditText editTextDa;
    EditText editTextA;
    EditText editTextCosto;
    Button bottoneAggiungi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_nuovo_trasferimento, container, false);
        calendarioSceltaData = vista.findViewById(R.id.calendarioSceltaData);
        editTextDa = vista.findViewById(R.id.editTextTextDa);
        editTextA = vista.findViewById(R.id.editTextTextA);
        editTextCosto = vista.findViewById(R.id.editTextCosto);
        bottoneAggiungi = vista.findViewById(R.id.bottoneAggiungi);

        calendarioSceltaData.setOnDateChangeListener(Applicazione.getInstance().getControlloNuovoTrasferimento().getAzioneSelezionaData());
        bottoneAggiungi.setOnClickListener(Applicazione.getInstance().getControlloNuovoTrasferimento().getAzioneNuovoTrasferimento());

        return vista;
    }

    public String getSquadraDa() {
        return this.editTextDa.getText().toString();
    }

    public String getSquadraA() {
        return this.editTextA.getText().toString();
    }

    public String getCosto() {
        return this.editTextCosto.getText().toString();
    }

    public void setErroreDa(String messaggio) {
        editTextDa.setError(messaggio);
    }

    public void setErroreA(String messaggio) {
        editTextA.setError(messaggio);
    }

    public void setErroreCosto(String messaggio) {
        editTextCosto.setError(messaggio);
    }


}
