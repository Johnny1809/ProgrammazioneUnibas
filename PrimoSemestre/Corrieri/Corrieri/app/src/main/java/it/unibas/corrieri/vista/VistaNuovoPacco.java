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

    CalendarView calendarioDataPacco;
    CheckBox checkBoxUrgente;
    TextView textViewMittenteSelezionato;
    TextView textViewDestinatarioSelezionato;
    Button bottoneAggiungiMittente;
    Button bottoneAggiungiDestinatario;
    EditText editTextPeso;
    Button bottoneSalvaPacco;

    public CalendarView getCalendarioDataPacco() {
        return calendarioDataPacco;
    }

    public CheckBox getCheckBoxUrgente() {
        return checkBoxUrgente;
    }

    public TextView getTextViewMittenteSelezionato() {
        return textViewMittenteSelezionato;
    }

    public TextView getTextViewDestinatarioSelezionato() {
        return textViewDestinatarioSelezionato;
    }

    public Button getBottoneAggiungiMittente() {
        return bottoneAggiungiMittente;
    }

    public Button getBottoneAggiungiDestinatario() {
        return bottoneAggiungiDestinatario;
    }

    public EditText getEditTextPeso() {
        return editTextPeso;
    }

    public Button getBottoneSalvaPacco() {
        return bottoneSalvaPacco;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_nuovo_pacco, container, false);

        calendarioDataPacco = vista.findViewById(R.id.calendarioDataPacco);
        checkBoxUrgente = vista.findViewById(R.id.checkBoxUrgente);
        textViewMittenteSelezionato = vista.findViewById(R.id.textViewMittenteSelezionato);
        bottoneAggiungiMittente = vista.findViewById(R.id.bottoneAggiungiMittente);
        textViewDestinatarioSelezionato = vista.findViewById(R.id.textViewDestinatarioSelezionato);
        bottoneAggiungiDestinatario = vista.findViewById(R.id.bottoneAggiungiDestinatario);
        editTextPeso = vista.findViewById(R.id.editTextPeso);
        bottoneSalvaPacco =  vista.findViewById(R.id.bottoneSalvaPacco);

        bottoneAggiungiMittente.setOnClickListener(Applicazione.getInstance().getControlloNuovoPacco().getAzioneAggiungiMittente());
        
        return vista;
    }
}
