package com.ancovy.funmath.datasource;

import android.content.Context;

import com.ancovy.funmath.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by msahakyan on 22/10/15.
 */
public class ExpandableListDataSource {

    /**
     * Returns fake data of films
     *
     * @param context
     * @return
     */
    public static Map<String, List<String>> getData(Context context) {
        Map<String, List<String>> expandableListData = new TreeMap<>();

        List<String> filmGenres = Arrays.asList(context.getResources().getStringArray(R.array.sd_class_expandable_drawer));

        List<String> actionFilms = Arrays.asList(context.getResources().getStringArray(R.array.kelas1_item_array));
        List<String> musicalFilms = Arrays.asList(context.getResources().getStringArray(R.array.kelas2_item_array));
        List<String> dramaFilms = Arrays.asList(context.getResources().getStringArray(R.array.kelas3_item_array));
        List<String> thrillerFilms = Arrays.asList(context.getResources().getStringArray(R.array.kelas4_item_array));
        List<String> comedyFilms = Arrays.asList(context.getResources().getStringArray(R.array.kelas5_item_array));
        List<String> comedyFilms2 = Arrays.asList(context.getResources().getStringArray(R.array.kelas6_item_array));


        expandableListData.put(filmGenres.get(0), actionFilms);
        expandableListData.put(filmGenres.get(1), musicalFilms);
        expandableListData.put(filmGenres.get(2), dramaFilms);
        expandableListData.put(filmGenres.get(3), thrillerFilms);
        expandableListData.put(filmGenres.get(4), comedyFilms);
        expandableListData.put(filmGenres.get(5), comedyFilms2);

        return expandableListData;
    }
}
