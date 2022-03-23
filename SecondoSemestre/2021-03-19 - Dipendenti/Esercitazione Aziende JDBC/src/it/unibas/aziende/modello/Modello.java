package it.unibas.aziende.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();
    
    public Object getBean(String key) {
        return beans.get(key);
    }
    
    public void putBean(String key, Object value){
        beans.put(key, value);
    }
    
}
