package inkadroid.com.viewpager;
import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
/*
Esta es una clase de Aplicación utilizada para proporcionar objetos
compartidos para esta aplicación, tales como:Tracker
*/
public class ViewPager extends Application {
    private static final int TIME_OUT = 10000;
    private static final int NUM_RETRY = 3;
    private static final String TAG = Application.class.getName();
    private RequestQueue requestQueue;
    private static ViewPagre instance
}
