package it.unibas.isee.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import it.unibas.isee.Applicazione;
import it.unibas.isee.Costanti;
import it.unibas.isee.R;
import it.unibas.isee.modello.ModuloIsee;
import it.unibas.isee.modello.StoriaCalcoli;

public class VistaPrincipale extends Fragment {

    private EditText campoReddito;
    private EditText campoPatrimonio;
    private EditText campoNumeroComponenti;
    private Switch switchMinori;
    private Button bottoneCalcola;
    private ListView listaModuli;

    private static final String TAG = VistaPrincipale.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false); //Un componente view è
                                                                                                // l'equivalente di un JComponent. In questo caso, vista sarà il riferimento alla ScrollView
        this.campoReddito = vista.findViewById(R.id.campoReddito);
        this.campoPatrimonio = vista.findViewById(R.id.campoPatrimonio);
        this.campoNumeroComponenti = vista.findViewById(R.id.campoComponenti);
        this.switchMinori = vista.findViewById(R.id.switchMinori);
        this.bottoneCalcola = vista.findViewById(R.id.bottoneCalcola);
        this.listaModuli = vista.findViewById(R.id.listaModuli);

        StoriaCalcoli storiaCalcoli = (StoriaCalcoli) Applicazione.getInstance().getModelloPersistente().getPersistentBean(Costanti.STORIA_CALCOLI, StoriaCalcoli.class);
        listaModuli.setAdapter(new AdapterStoriaCalcoli(storiaCalcoli.getStoria()));
        aggiornaListaModuli();

        this.bottoneCalcola.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneCalcola());
        this.listaModuli.setOnItemClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneSelezioneStoria());

        return vista;
    }

    public String getCampoReddito() {
        return this.campoReddito.getText().toString();
    }

    public String getCampoPatrimonio() {
        return this.campoPatrimonio.getText().toString();
    }

    public String getCampoNumeroComponenti() {
        return this.campoNumeroComponenti.getText().toString();
    }

    public boolean getSwitchMinori() {
        return this.switchMinori.isChecked();
    }

    public void setErroreReddito(String messaggio) {
        this.campoReddito.setError(messaggio);
    }

    public void setErrorePatrimonio(String messaggio){
        this.campoPatrimonio.setError(messaggio);
    }

    public void setErroreNumeroComponenti(String messaggio) {
        this.campoNumeroComponenti.setError(messaggio);
    }

    public void aggiornaListaModuli() {
        AdapterStoriaCalcoli adapter = (AdapterStoriaCalcoli) listaModuli.getAdapter();
        adapter.aggiornaContenuto();
    }

    public void setCampiPrecompilati(ModuloIsee moduloIsee) {
        this.campoReddito.setText(moduloIsee.getReddito() + "");
        this.campoPatrimonio.setText(moduloIsee.getPatrimonio() + "");
        this.campoNumeroComponenti.setText(moduloIsee.getNumeroComponenti() + "");
        this.switchMinori.setChecked(moduloIsee.isPresenzaMinori());
    }

}
