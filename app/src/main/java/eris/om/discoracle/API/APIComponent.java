package eris.om.discoracle.API;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gorka on 11/04/2016.
 */
@Singleton
@Component(modules = APIModule.class)
public interface APIComponent {
    LunaAPIConsumer getLunaAPIConsumer();
}
