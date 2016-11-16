package com.chensd.byeburgertest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoveFragment extends Fragment {

    private String name;

    public LoveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoveFragment newInstance(String name) {
        LoveFragment fragment = new LoveFragment();
        Bundle args = new Bundle();
        args.putString("name",name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            name = args.getString("name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(name);
        return view;
    }

}
