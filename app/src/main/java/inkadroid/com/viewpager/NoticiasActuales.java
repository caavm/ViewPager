package inkadroid.com.viewpager;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class NoticiasActuales extends Fragment {
    private RecyclerView recyclerView;
    private TextView txt_notFound;
    private List<News> currentNews=new ArrayList<>();
    private ProgressDialog dialog;


    public NoticiasActuales() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias_actuales, container, false);
    }

    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView) view.findViewById(R.id.recycler);
        txt_notFound=(TextView) view.findViewById(R.id.txt_notfound);
        dialog=ProgressDialog.show(getContext(),"Cargando...","Por favor espere unos segundos...",true,false);
        inkadroid.com.viewpager.ViewPager.getInstance().add(new StringRequest(Request.Method.GET, "http://www.inkadroid.com/bursatil/obtain_current_news.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<List<News>>() {
                }.getType();
                currentNews = new Gson().fromJson(response, listType);
                NewsAdapter newsAdapter = new NewsAdapter(getActivity(), currentNews);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(newsAdapter);
                dialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                recyclerView.setVisibility(View.GONE);
                txt_notFound.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        }
        ));
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
