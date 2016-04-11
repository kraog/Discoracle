package eris.om.discoracle.API;


import eris.om.discoracle.model.Luna;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Gorka on 04/04/2016.
 */
public interface LunaAPI {

    @GET("/")
    Observable<Luna> getFeed();
}
