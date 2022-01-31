package it.unibas.playground.vista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import it.unibas.playground.Applicazione;
import it.unibas.playground.R;

public class VistaPrincipale extends Fragment {

    Button bottoneStartActivityForResult;
    Button bottoneApriGoogle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);

        bottoneStartActivityForResult = vista.findViewById(R.id.bottoneStartaActivityForResult);
        bottoneApriGoogle = vista.findViewById(R.id.bottoneApriGoogle);

        bottoneStartActivityForResult.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneStartActivityForResult());
        bottoneApriGoogle.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneApriGoogle());

        return vista;
    }
}
