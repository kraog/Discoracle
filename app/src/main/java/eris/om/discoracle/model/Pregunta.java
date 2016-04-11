package eris.om.discoracle.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import eris.om.discoracle.BR;


/**
 * Created by Gorka on 23/03/2016.
 */

public class Pregunta extends BaseObservable{

    private String nombre;
    private String descripcion;

    @Bindable
    public String getNombre() {

        return nombre;
    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

        notifyPropertyChanged(BR.nombre);
    }

    public TextWatcher onNombreChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            setNombre(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Bindable
    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
        notifyPropertyChanged(BR.descripcion);
    }


    public TextWatcher onDescripcionChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setDescripcion(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
