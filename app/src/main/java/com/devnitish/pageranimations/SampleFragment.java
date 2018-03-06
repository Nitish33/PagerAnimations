package com.devnitish.pageranimations;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {

    int no;

    int color  = R.color.color1;
    int color2 = R.color.color2;

    public SampleFragment() {
        // Required empty public constructor

    }

    public SampleFragment(int no){

        this();
        this.no = no;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sample, container, false);

        TextView textView =   ((TextView)view.findViewById(R.id.text));
        textView.setText(""+no);

        if(no%2==0) {
            textView.setTextColor(getResources().getColor(color));
            view.setBackgroundResource(color2);
        }
        else {
            textView.setTextColor(getResources().getColor(color2));
            view.setBackgroundResource(color);
        }



        return view;
    }

}
