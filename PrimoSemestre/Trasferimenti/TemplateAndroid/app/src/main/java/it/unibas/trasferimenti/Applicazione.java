package it.unibas.trasferimenti;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import it.unibas.trasferimenti.controllo.ControlloDettagliCalciatore;
import it.unibas.trasferimenti.controllo.ControlloNuovoTrasferimento;
import it.unibas.trasferimenti.controllo.ControlloPrincipale;
import it.unibas.trasferimenti.modello.Modello;
import it.unibas.trasferimenti.modello.ModelloPersistente;
import it.unibas.trasferimenti.persistenza.DAOServerMock;
import it.unibas.trasferimenti.persistenza.IDAOServer;

public class Applicazione extends Application {

    public static final String TAG = Applicazione.class.getSimpleName();

    private static Applicazione singleton;

    public static Applicazione getInstance() {
        return singleton;
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Applicazione creata...");
        singleton = (Applicazione) getApplicationContext();
        singleton.registerActivityLifecycleCallbacks(new GestoreAttivita());
    }

    /////////////////////////////////////////////

    private Activity currentActivity = null;

    private Modello modello = new Modello();
    private ModelloPersistente modelloPersistente = new ModelloPersistente();
    private IDAOServer daoServer = new DAOServerMock();
    private ControlloPrincipale controlloPrincipale = new ControlloPrincipale();
    private ControlloDettagliCalciatore controlloDettagliCalciatore = new ControlloDettagliCalciatore();
    private ControlloNuovoTrasferimento controlloNuovoTrasferimento = new ControlloNuovoTrasferimento();

    public ControlloNuovoTrasferimento getControlloNuovoTrasferimento() {
        return controlloNuovoTrasferimento;
    }

    public ControlloDettagliCalciatore getControlloDettagliCalciatore() {
        return controlloDettagliCalciatore;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public IDAOServer getDaoServer() {
        return daoServer;
    }

    public Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public Modello getModello() {
        return modello;
    }

    public ModelloPersistente getModelloPersistente() {
        return modelloPersistente;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    private class GestoreAttivita implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            //Log.i(TAG, "onActivityCreated: " + activity);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            //Log.i(TAG, "onActivityDestroyed: " + activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            //Log.d(TAG, "onActivityStarted: " + activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.d(TAG, "currentActivity initialized: " + activity);
            currentActivity = activity;
        }

        @Override
        public void onActivityPaused(Activity activity) {
            //Log.d(TAG, "onActivityPaused: " + activity);
        }

        @Override
        public void onActivityStopped(Activity activity) {
            if (currentActivity == activity) {
                Log.d(TAG, "currentActivity stopped: " + activity);
                currentActivity = null;
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            //Log.d(TAG, "onActivitySaveInstanceState: " + activity);
        }
    }
}
