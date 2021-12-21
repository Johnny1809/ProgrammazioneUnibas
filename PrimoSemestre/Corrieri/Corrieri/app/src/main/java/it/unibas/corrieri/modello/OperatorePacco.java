package it.unibas.corrieri.modello;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class OperatorePacco {

    private String TAG = OperatorePacco.class.getSimpleName();

    public boolean verificaResoValido(Utente destinatario, Utente mittente, Calendar dataInvio, double pesoDaVerificare) {
        //se il pacco è un reso e non è valido, ritorna false;
        boolean resoValido = true;
        Pacco pacco = destinatario.cercaPaccoInviatoEntro15ggPrima(mittente, dataInvio);
        if (pacco != null && (pacco.getPeso()) != pesoDaVerificare) {
            resoValido = false;
        }
        return resoValido;
    }

    public boolean verificaDataPaccoUrgente(Calendar data) {
        //true se il pacco ha una data valida, false altrimenti... attenzione, la data in input deve essere quella di un pacco urgente
        Calendar domani = new GregorianCalendar();
        domani.add(Calendar.DAY_OF_MONTH,1);
        if (data.after(domani)) {
            return false;
        }
        return true;
    }

}
