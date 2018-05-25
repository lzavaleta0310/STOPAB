package mx.com.lania.controlasmaapp.app;

import android.app.Application;
import android.content.Context;

import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;

public class AppController extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
