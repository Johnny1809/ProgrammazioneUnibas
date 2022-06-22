package it.unibas.ricette.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatoreRicette {

    private static Logger logger = LoggerFactory.getLogger(OperatoreRicette.class);

    public List<Prestazione> getPrescrizioniSuggerite(List<Ricetta> tutteLeRicette, String tipologia) {
        String secondaTipologia = this.getSecondaTipologiaFrequente(tutteLeRicette, tipologia);
        logger.debug("Seconda tipologia scelta =" +  secondaTipologia);
        if (secondaTipologia == null) {
            return null;
        }
        List<PrestazioneFrequenza> prescrizioniPiuFrequenti = getPrescrizioniPiuFrequenti(tutteLeRicette, secondaTipologia);
        logger.debug("Prestazioni più frequenti =" + prescrizioniPiuFrequenti);
        List<Prestazione> prestazioniSuggerite = new ArrayList<>();
        for (PrestazioneFrequenza prestazioneFrequenza : prescrizioniPiuFrequenti) {
            prestazioniSuggerite.add(prestazioneFrequenza.getPrestazione());
        }
        logger.debug("Prestazioni suggerite =" +  prestazioniSuggerite);
        return prestazioniSuggerite;
    }

    public List<PrestazioneFrequenza> getPrescrizioniPiuFrequenti(List<Ricetta> tutteLeRicette, String tipologia) {
        List<Prestazione> prestazioni = estraiPrestazioni(tutteLeRicette, tipologia);
        List<PrestazioneFrequenza> piuFrequenti = calcolaPiuFrequenti(prestazioni, 3);
        return piuFrequenti;
    }

    public String getSecondaTipologiaFrequente(List<Ricetta> tutteLeRicette, String tipologia) {
        Map<String, Integer> tipologiaFrequenza = this.calcolaTipologieEFrequenze(tutteLeRicette);
        String secondaTipologia = estraiMassimo(tipologiaFrequenza, tipologia);
        return secondaTipologia;
    }

    public Map<String, Integer> calcolaTipologieEFrequenze(List<Ricetta> tutteLeRicette) {
        Map<String, Integer> tipologiaFrequenza = new HashMap<>();
        for (Ricetta ricetta : tutteLeRicette) {
            String tipologiaCorrente = ricetta.getTipologia();
            if (tipologiaCorrente.isBlank()) {
                continue;
            }
            Integer frequenza = tipologiaFrequenza.get(tipologiaCorrente);
            if (frequenza == null) {
                tipologiaFrequenza.put(tipologiaCorrente, 1);
            } else {
                tipologiaFrequenza.put(tipologiaCorrente, frequenza + 1);
            }
        }
        return tipologiaFrequenza;
    }

    private String estraiMassimo(Map<String, Integer> tipologiaFrequenza, String tipologia) {
        int massimo = 0;
        String secondaTipologia = "";
        for (String tipologiaCorrente : tipologiaFrequenza.keySet()) {
            if (tipologiaCorrente.equalsIgnoreCase(tipologia) || tipologiaFrequenza.get(tipologiaCorrente) > tipologiaFrequenza.get(tipologia)) {
                continue;
            }
            int frequenzaCorrente = tipologiaFrequenza.get(tipologiaCorrente);
            if (frequenzaCorrente >= massimo) {
                secondaTipologia = tipologiaCorrente;
            }
        }
        return secondaTipologia;
    }

    private List<Prestazione> estraiPrestazioni(List<Ricetta> tutteLeRicette, String tipologia) {
        List<Prestazione> risultato = new ArrayList<>();
        for (Ricetta ricetta : tutteLeRicette) {
            if (ricetta.getTipologia().equalsIgnoreCase(tipologia)) {
                risultato.addAll(ricetta.getPrestazioni());
            }
        }
        return risultato;
    }

    private List<PrestazioneFrequenza> calcolaPiuFrequenti(List<Prestazione> prestazioni, int numeroDiPrestazioni) {
        Map<Prestazione, Integer> mappaPrestazioneOccorrenze = new HashMap<>();
        for (Prestazione prestazione : prestazioni) {
            Integer occorrenze = mappaPrestazioneOccorrenze.get(prestazione);
            if (occorrenze == null) {
                mappaPrestazioneOccorrenze.put(prestazione, 1);
            } else {
                mappaPrestazioneOccorrenze.put(prestazione, occorrenze + 1);
            }
        }
        List<PrestazioneFrequenza> prestazioniFrequenze = new ArrayList<>();
        for (Prestazione prestazione : mappaPrestazioneOccorrenze.keySet()) {
            int occorrenze = mappaPrestazioneOccorrenze.get(prestazione);
            prestazioniFrequenze.add(new PrestazioneFrequenza(occorrenze, prestazione));
        }
        Collections.sort(prestazioniFrequenze);
        Collections.reverse(prestazioniFrequenze);
        return prestazioniFrequenze.subList(0, Integer.min(numeroDiPrestazioni, prestazioniFrequenze.size()));
    }

}
