package eris.om.discoracle;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eris.om.discoracle.API.DaggerAPIComponent;
import eris.om.discoracle.API.LunaAPI;
import eris.om.discoracle.API.LunaAPIConsumer;
import eris.om.discoracle.databinding.FrontBinding;
import eris.om.discoracle.model.Luna;
import eris.om.discoracle.model.Pregunta;
import eris.om.discoracle.model.Respuesta;
import eris.om.discoracle.viewmodel.FrontViewModel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A placeholder fragment containing a simple view.
 */
public class FrontFragment extends Fragment implements FrontViewModel.FrontListener{
    FragmentManager fragmentManager;
    static String tag = "front_fragment";
    FrontBinding binding;
    String lunadistancia;
    String nombre;
    LunaAPIConsumer lunaAPIConsumer;

    public FrontFragment() {
    }
    public static FrontFragment newInstance(){
        FrontFragment ff = new FrontFragment();

        return ff;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.front,container,false);
        binding.setViewModel(new FrontViewModel(this));
        return  binding.getRoot();
    }

    @Override
    public void onFabClicked() {
        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        nombre = binding.cajaNombre.getText().toString();

        DaggerAPIComponent.create().getLunaAPIConsumer().getFeed().subscribe(new Subscriber<Luna>() {
                    @Override
                    public void onCompleted() {
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        failure();
                        unsubscribe();
                    }

                    @Override
                    public void onNext(Luna luna) {
                        success(luna);
                    }
                });
    }

    public void success(Luna luna) {
        lunadistancia = "" + luna.getDFS();
        setResponse(fragmentManager, lunadistancia);
    }

    public void failure() {
        lunadistancia = "muchos";
        setResponse(fragmentManager, lunadistancia);
    }

    private void setResponse(FragmentManager fragmentManager, String lunadistance){
        Respuesta respuesta = new Respuesta();
        respuesta.setDescripcionr(getString(R.string.string_frase_respuesta, nombre, lunadistance));
        OracleFragment ofragment = OracleFragment.newInstance(respuesta);

        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.main_fragment, ofragment, OracleFragment.tag);
        transaction2.commit();
    }
}
