package eris.om.discoracle.util;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gorka on 11/04/2016.
 */
@Module
public class PropertiesModule {


    @Singleton
    @Provides
    public PropertiesReader getPropertiesReader(){
        return new PropertiesReader();
    }
}
