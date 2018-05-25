package mx.com.lania.controlasmaapp.viewmodel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import mx.com.lania.controlasmaapp.view.fragments.CausasFragment;
import mx.com.lania.controlasmaapp.view.fragments.ExacerbacionesFragment;
import mx.com.lania.controlasmaapp.view.fragments.HomeFragment;
import mx.com.lania.controlasmaapp.view.fragments.ICFemFragment;
import mx.com.lania.controlasmaapp.view.fragments.MedicamentoEmergenciaFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    // Tab Titles
    private String tabtitles[] = new String[] { "Semáforo FEM", "Exacerbaciones", "Causas", "Medicamento\nde emergencia" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ICFemFragment fragmenttab1 = new ICFemFragment();
                return fragmenttab1;
            case 1:
                ExacerbacionesFragment fragmenttab2 = new ExacerbacionesFragment();
                return fragmenttab2;
            case 2:
                CausasFragment fragmenttab3 = new CausasFragment();
                return fragmenttab3;
            case 3:
                MedicamentoEmergenciaFragment fragmenttab4 = new MedicamentoEmergenciaFragment();
                return fragmenttab4;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    public Fragment getElemento(int position){
        return getItem(position);
    }

}
