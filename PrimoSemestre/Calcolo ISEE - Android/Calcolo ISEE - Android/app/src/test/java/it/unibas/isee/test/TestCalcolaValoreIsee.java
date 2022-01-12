package it.unibas.isee.test;

import junit.framework.TestCase;
import it.unibas.isee.modello.ModuloIsee;

public class TestCalcolaValoreIsee extends TestCase {

    public void testCalcolo1() {
        ModuloIsee moduloIsee = new ModuloIsee(35000, 12000,3,true);
        assertEquals(14960.0,moduloIsee.getValoreISEE(), 0.001);
    }

}
