package eris.om.discoracle;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eris.om.discoracle.databinding.OracleBinding;
import eris.om.discoracle.model.Respuesta;
import eris.om.discoracle.viewmodel.OracleViewModel;


public class OracleFragment extends Fragment implements OracleViewModel.OracleListener{
    static String tag = "oracle_fragment";
    private Respuesta respuesta;

    public OracleFragment() {
    }
    public static OracleFragment newInstance(Respuesta respuesta){
        OracleFragment of = new OracleFragment();
        of.setRespuesta(respuesta);
        return of;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        OracleBinding binding = DataBindingUtil.inflate(inflater, R.layout.oracle, container, false);
        binding.setOracleViewModel(new OracleViewModel(this, respuesta));
        binding.cajaRespuesta.setText(respuesta.getDescripcionr());

        return  binding.getRoot();
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public void onVueltaClicked() {
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.main_fragment, new FrontFragment(), FrontFragment.tag);
        transaction2.commit();
    }
}
