package eris.om.discoracle.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import eris.om.discoracle.BR;

/**
 * Created by Gorka on 23/03/2016.
 */

public class Respuesta extends BaseObservable {


    private String descripcionr;
    private String imagen_src;


    @Bindable
    public String getDescripcionr() {
        return descripcionr;
    }

    public void setDescripcionr(String descripcionr) {

        this.descripcionr = descripcionr;
        notifyPropertyChanged(BR.descripcionr);
    }


    @Bindable
    public String getImagen_src() {
        return imagen_src;
    }

    public void setImagen_src(String imagen_src) {
        this.imagen_src = imagen_src;
        notifyPropertyChanged(BR.imagen_src);
    }
}
