package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ancovy.funmath.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAction2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAction2 extends Fragment {

    private static final String KEY_MOVIE_TITLE = "key_title";
    private CountDownTimer timer;

    public FragmentAction2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FragmentAction.
     */
    public static FragmentAction2 newInstance(String movieTitle) {
        FragmentAction2 fragmentAction = new FragmentAction2();
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
        return inflater.inflate(R.layout.fragment_action2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView text = (TextView)view.findViewById(R.id.textview_clock_latihan);

        timer = new CountDownTimer(7200000, 1000) {

            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished/1000;
                text.setText(time/60 + " : " + time%60);
            }

            public void onFinish() {
                text.setText("00 : 00");
            }

        }.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        timer.cancel();
    }
}
