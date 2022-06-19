package it.unibas.cantine.modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatoreStatisticaVendemmia {

    public List<StatisticaVendemmia> calcolaStatistica(List<Vitigno> tuttiIVitigni) {
        List<StatisticaVendemmia> risultato = new ArrayList<>();
        Map<String, List<Vitigno>> mappaNomeVitigni = dividiPerNome(tuttiIVitigni);
        for (List<Vitigno> vitigniRaggruppati : mappaNomeVitigni.values()) {
            MeseOccorrenze mesePreferito = calcolaMeseFrequente(vitigniRaggruppati);
            int qualita = calcolaQualitaMassima(vitigniRaggruppati);
            StatisticaVendemmia statisticaVendemmia = new StatisticaVendemmia(vitigniRaggruppati.get(0), mesePreferito.getMese(), mesePreferito.getOccorrenze(), qualita);
            risultato.add(statisticaVendemmia);
        }
        return risultato;

    }

    private MeseOccorrenze calcolaMeseFrequente(List<Vitigno> vitigniPerNome) {
        MeseOccorrenze risultato = null;
        Map<Integer, Integer> mappaMeseOccorrenze = new HashMap<Integer, Integer>();
        for (Vitigno vitigno : vitigniPerNome) {
            int meseVitigno = vitigno.getAnnata().getMese();
            Integer occorrenze = mappaMeseOccorrenze.get(meseVitigno);
            if (occorrenze == null) {
                mappaMeseOccorrenze.put(meseVitigno, 1);
            } else {
                mappaMeseOccorrenze.put(meseVitigno, occorrenze + 1);
            }
        }
        risultato = calcolaMesePiuFrequente(mappaMeseOccorrenze);
        return risultato;
    }

    private Map<String, List<Vitigno>> dividiPerNome(List<Vitigno> tuttiIVitigni) {
        Map<String, List<Vitigno>> risultato = new HashMap<>();
        for (Vitigno vitigno : tuttiIVitigni) {
            String nomeVitignoCorrente = vitigno.getNomeUva();
            List<Vitigno> vitigniDelNome = risultato.get(nomeVitignoCorrente);
            if (vitigniDelNome == null) {
                vitigniDelNome = new ArrayList<>();
                vitigniDelNome.add(vitigno);
                risultato.put(nomeVitignoCorrente, vitigniDelNome);
            } else {
                vitigniDelNome.add(vitigno);
            }
        }
        return risultato;
    }

    private MeseOccorrenze calcolaMesePiuFrequente(Map<Integer, Integer> mappaMeseOccorrenze) {
        int mesePiuFrequente = -1;
        int occorrenzePiuFrequente = -1;
        for (Integer mese : mappaMeseOccorrenze.keySet()) {
            int occorrenze = mappaMeseOccorrenze.get(mese);
            if (occorrenze > occorrenzePiuFrequente) {
                mesePiuFrequente = mese;
                occorrenzePiuFrequente = occorrenze;
            }
        }
        return new MeseOccorrenze(mesePiuFrequente, occorrenzePiuFrequente);
    }

    private int calcolaQualitaMassima(List<Vitigno> vitigniRaggruppati) {
        int qualitaMassima = -1;
        for (Vitigno vitigno : vitigniRaggruppati) {
            int qualita = vitigno.getAnnata().getQualita();
            if (qualita > qualitaMassima) {
                qualitaMassima = qualita;
            }
        }
        return qualitaMassima;
    }

}
