package eris.om.discoracle.viewmodel;

import android.view.View;

import eris.om.discoracle.model.Respuesta;

/**
 * Created by Gorka on 04/04/2016.
 */
public class OracleViewModel {
    public OracleListener mOracleListener;
    public Respuesta respuesta;

    public OracleViewModel(final OracleListener olis, Respuesta respuesta) {
        this.mOracleListener = olis;
        this.respuesta = respuesta;
    }

    public interface OracleListener {
        public void onVueltaClicked();
    }

    public void onVueltaClick(View view) {
        mOracleListener.onVueltaClicked();
    }
}
