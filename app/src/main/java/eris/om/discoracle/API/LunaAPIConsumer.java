package eris.om.discoracle.API;

import android.app.Fragment;
import android.view.View;

import eris.om.discoracle.R;
import eris.om.discoracle.model.Luna;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Gorka on 06/04/2016.
 */
public class LunaAPIConsumer {

    private final LunaAPI lunapi;
    private LunaAPIConsumer(){
        String api = "http://api.burningsoul.in/moon";
        RestAdapter restAdapter = new RestAdapter.Builder().
                setLogLevel(RestAdapter.LogLevel.FULL).
                setEndpoint(api).
                build();
        lunapi = restAdapter.create(LunaAPI.class);
    }
    public static LunaAPIConsumer newInstance(){
        return new LunaAPIConsumer();
    }

    public Observable<Luna> getFeed(){
        return lunapi.getFeed().
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread());
    }
}
