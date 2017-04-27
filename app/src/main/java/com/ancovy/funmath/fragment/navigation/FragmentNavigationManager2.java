package com.ancovy.funmath.fragment.navigation;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ancovy.funmath.BuildConfig;
import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.Main3Activity;
import com.ancovy.funmath.activity.Main4Activity;
import com.ancovy.funmath.fragment.FragmentAction;
import com.ancovy.funmath.fragment.FragmentAction2start;

/**
 * @author msahakyan
 */

public class FragmentNavigationManager2 implements NavigationManager {

    private static FragmentNavigationManager2 sInstance;

    private FragmentManager mFragmentManager;
    private Main4Activity mActivity;

    public static FragmentNavigationManager2 obtain(Main4Activity activity) {
        if (sInstance == null) {
            sInstance = new FragmentNavigationManager2();
        }
        sInstance.configure(activity);
        return sInstance;
    }

    private void configure(Main4Activity activity) {
        mActivity = activity;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragmentAction(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    @Override
    public void showFragmentComedy(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    @Override
    public void showFragmentDrama(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    @Override
    public void showFragmentMusical(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    @Override
    public void showFragmentThriller(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    @Override
    public void showFragmentSix(String title) {
        showFragment(FragmentAction2start.newInstance(title), false);
    }

    private void showFragment(Fragment fragment, boolean allowStateLoss) {
        FragmentManager fm = mFragmentManager;

        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction()
            .replace(R.id.container, fragment);

        ft.addToBackStack(null);

        if (allowStateLoss || !BuildConfig.DEBUG) {
            ft.commitAllowingStateLoss();
        } else {
            ft.commit();
        }

        fm.executePendingTransactions();
    }
}
