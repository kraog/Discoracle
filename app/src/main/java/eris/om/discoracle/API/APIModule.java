package eris.om.discoracle.API;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gorka on 11/04/2016.
 */
@Module
public class APIModule {

    @Singleton
    @Provides
    LunaAPIConsumer getSingLunaAPIConsumer(){
        return LunaAPIConsumer.newInstance();
    }
}
