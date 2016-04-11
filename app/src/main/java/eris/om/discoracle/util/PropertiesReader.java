package eris.om.discoracle.util;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eris.om.discoracle.MainActivity;


public class PropertiesReader extends Application{
    private Properties properties;

    public PropertiesReader() {
        //creates a new object ‘Properties’
        properties = getProperties("discoracle.properties");
    }
    public String getString(String key){
        return this.properties.getProperty(key);
    }


    public Properties getProperties(String FileName) {
        try {
            //access to the folder ‘assets’
            AssetManager am = getApplicationContext().getAssets();
            //opening the file
            InputStream inputStream = am.open(FileName);
            //loading of the properties
            properties.load(inputStream);
        } catch (IOException e) {
            Log.e("PropertiesReader", e.toString());
        }
        return properties;
    }
}

