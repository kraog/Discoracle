package eris.om.discoracle.viewmodel;

        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.view.View;

        import eris.om.discoracle.OracleFragment;
        import eris.om.discoracle.R;
        import eris.om.discoracle.model.Pregunta;
        import eris.om.discoracle.model.Respuesta;

/**
 * Created by Gorka on 01/04/2016.
 */
public class FrontViewModel {
    public FrontListener mFrontListener;
    public Pregunta pregunta;

    public FrontViewModel(final FrontListener fl){
        this.mFrontListener = fl;
    }

    public void setPregunta(Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public interface FrontListener {
        public void onFabClicked();
    }
    public void onFabButtonClick(View view){
        mFrontListener.onFabClicked();
    }
}
