package eris.om.discoracle.util;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gorka on 11/04/2016.
 */
@Singleton
@Component(modules = PropertiesModule.class)
public interface PropertiesComponent {
    PropertiesReader getPropertiesReader();
}
