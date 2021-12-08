package it.unibas.corrieri.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.GregorianCalendar;

import it.unibas.corrieri.modello.OperatorePacco;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class TestOperatorePacco extends TestCase {

    private OperatorePacco operatorePacco = new OperatorePacco();

    private Utente utenteGiovanni = new Utente("G1", "Giovanni Taddei", "Via Roma", 23);
    private Utente utenteRoberta = new Utente("R2", "Roberta Marotta", "Oscar Romero", 13);
    private Calendar dataCorrente = new GregorianCalendar();
    private Calendar dopodomani;
    private Calendar domani;
    private Pacco p1;
    private Pacco p3;
    private Pacco p4;

    {

        this.dopodomani = (Calendar)dataCorrente.clone();
        this.dopodomani.add(Calendar.DAY_OF_MONTH, 2);
        this.domani = (Calendar)dataCorrente.clone();
        this.domani.add(Calendar.DAY_OF_MONTH, 1);

        //Pacco1: urgente e data corretta
        p1 = new Pacco(dataCorrente,3.4, true, utenteGiovanni, utenteRoberta);
        //Pacco2: non urgente generico
        //Pacco p2 = new Pacco(dopodomani,5.4, false, utenteGiovanni, utenteRoberta);
        //Pacco3: urgente e con data sbagliata
        // risulta essere un reso di un pacco che Giovanni aveva inviato a Roberta, ma il peso è sbagliato
        p3 = new Pacco(dopodomani, 2.0, true, utenteRoberta, utenteGiovanni);
        //Pacco4: risulta essere un reso di un pacco che Giovanni aveva inviato a Roberta, il peso è corretto
        p4 = new Pacco(dopodomani, 3.4, true, utenteRoberta, utenteGiovanni);

        utenteGiovanni.getPacchiInviati().add(p1);
        utenteRoberta.getPacchiInviati().add(p3);
        utenteRoberta.getPacchiInviati().add(p4);
    }


    public void testVerificaPaccoUrgenteCorretto () {
        Assert.assertTrue(operatorePacco.verificaDataPaccoUrgente(p1.getDataInvio()));
    }

    public void testVerificaPacchoUrgenteSbagliato() {
        Assert.assertFalse(operatorePacco.verificaDataPaccoUrgente(p3.getDataInvio()));
    }

    public void testVerificaResoSbagliato(){
        Assert.assertFalse(operatorePacco.verificaResoValido(utenteGiovanni, utenteRoberta, p3.getDataInvio(), p3.getPeso()));
    }

    public void testVerificaResoCorretto() {
        Assert.assertTrue(operatorePacco.verificaResoValido(utenteGiovanni, utenteRoberta, p4.getDataInvio(), p4.getPeso()));
    }

}