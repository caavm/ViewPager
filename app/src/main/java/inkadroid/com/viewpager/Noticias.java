package inkadroid.com.viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;


public class Noticias extends Fragment {
private static List<Fragment> fragments;
    static{
        fragments = new ArrayList<>();
        fragments.add(new NoticiasActuales());
        //fragments.add(new NoticiasAntiguas());

    }

    public Noticias() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias, container, false);
    }


    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        android.support.v4.view.ViewPager viewPager = (android.support.v4.view.ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(),fragments,getResources().getStringArray(R.array.news_sections)));
        TabLayout tabLayout=(TabLayout) view.findViewById(R.id.appbartabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
