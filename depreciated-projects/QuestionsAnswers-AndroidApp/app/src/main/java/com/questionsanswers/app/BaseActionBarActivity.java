
package com.questionsanswers.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.questionsanswers.model.CampoFormulario;
import com.questionsanswers.model.Formulario;
import com.questionsanswers.model.TipoCampo;

import java.util.ArrayList;

public abstract class BaseActionBarActivity extends ActionBarActivity {

    protected abstract int getLayoutResourceId();
    protected final String TAG_CLASS = this.getClass().getSimpleName();

    // Metodos do Ciclo de Vida da Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        Log.i(TAG_CLASS, "Metodo 'onCreate'");
    }

    public String getIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(
            Context.TELEPHONY_SERVICE
        );
        return telephonyManager.getDeviceId();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_CLASS, "Metodo 'onStart'");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG_CLASS, "Metodo 'onStop'");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_CLASS, "Metodo 'onRestart'");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_CLASS, "Metodo 'onPause'");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_CLASS, "Metodo 'onResume'");
    }

    @Override
    public void finish() {
        super.finish();
        Log.w(TAG_CLASS, "Metodo 'finish'");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG_CLASS, "Metodo 'onDestroy'");
    }

}
