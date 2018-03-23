package iut.paci.classroomcommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


//import com.google.gson.*;



/**
 * Created by AurélienPC on 23/03/2018.
 */

public class FirstFragment extends Fragment {
    public FirstFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("First title");
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView
                ;


    }
}
