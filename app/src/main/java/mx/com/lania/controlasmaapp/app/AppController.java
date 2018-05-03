package mx.com.lania.controlasmaapp.app;

import android.app.Application;
import android.content.Context;

import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;

public class AppController extends Application{
    private Services services;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public Services getServices() {
        if (services == null){
            //services = Api.create();
        }
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
