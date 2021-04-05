package com.example.tp3conversor;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> resultadoMutable;

    public MutableLiveData<String> getResultadoMutable() {
        if(resultadoMutable==null) {
            resultadoMutable=new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void convertiraEuro(String n) {
        try {
            double dolar= Double.parseDouble(n);
            double res= (dolar * 0.85);
            resultadoMutable.setValue(res+ "");
        }catch (Exception ex) {
            resultadoMutable.setValue("Error, no se pudo convertir!!");

        }
    }

    public void convertiraDolar(String n) {
        try {
            double euro= Double.parseDouble(n);
            double res= (euro * 1.18);
            resultadoMutable.setValue(res+ "");
        }catch (Exception ex) {
            resultadoMutable.setValue("Lo sentimos, error :( ");
        }
    }


}
