package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;

public class VistaNuovoPacco extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_nuovo_pacco, container, false);
        CalendarView calendarioDataPacco = vista.findViewById(R.id.calendarioDataPacco);
        CheckBox checkBoxUrgente = vista.findViewById(R.id.checkBoxUrgente);
        TextView textViewMittenteSelezionato = vista.findViewById(R.id.textViewMittenteSelezionato);
        Button bottoneAggiungiMittente = vista.findViewById(R.id.bottoneAggiungiMittente);
        TextView textViewDestinatarioSelezionato = vista.findViewById(R.id.textViewDestinatarioSelezionato);
        Button bottoneAggiungiDestinatario = vista.findViewById(R.id.bottoneAggiungiDestinatario);
        EditText editTextPeso = vista.findViewById(R.id.editTextPeso);
        Button bottoneSalvaPacco =  vista.findViewById(R.id.bottoneSalvaPacco);

        bottoneAggiungiMittente.setOnClickListener(Applicazione.getInstance().getControlloNuovoPacco().getAzioneAggiungiMittente());
        
        return vista;
    }
}
