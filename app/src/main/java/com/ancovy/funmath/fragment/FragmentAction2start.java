package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ancovy.funmath.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAction2start#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAction2start extends Fragment {

    private static final String KEY_MOVIE_TITLE = "key_title";
    private Button start;

    public FragmentAction2start() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FragmentAction.
     */
    public static FragmentAction2start newInstance(String movieTitle) {
        FragmentAction2start fragmentAction = new FragmentAction2start();
        Bundle args = new Bundle();
        args.putString(KEY_MOVIE_TITLE, movieTitle);
        fragmentAction.setArguments(args);

        return fragmentAction;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_action2start, container, false);

        start = (Button)view.findViewById(R.id.start_button_latihan);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.container, new FragmentAction2()).commit();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
