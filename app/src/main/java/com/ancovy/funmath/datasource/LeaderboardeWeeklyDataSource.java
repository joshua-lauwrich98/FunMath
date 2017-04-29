package com.ancovy.funmath.datasource;

import android.content.Context;

import com.ancovy.funmath.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DarKnight98 on 4/29/2017.
 */

public class LeaderboardeWeeklyDataSource {

    public static HashMap<String, List<String>> getData(Context context) {
        HashMap<String, List<String>> data = new HashMap<>();

        List<String> kategori = Arrays.asList(context.getResources().getStringArray(R.array.leaderboard_kategori));

        List<String> peringkat = Arrays.asList(context.getResources().getStringArray(R.array.leaderboard_peringkat));
        List<String> username = Arrays.asList(context.getResources().getStringArray(R.array.leaderboard_username));
        List<String> score = Arrays.asList(context.getResources().getStringArray(R.array.leaderboard_score));
        List<String> icon = Arrays.asList(context.getResources().getStringArray(R.array.leaderboard_icon));


        data.put(kategori.get(0), peringkat);
        data.put(kategori.get(1), username);
        data.put(kategori.get(2), score);
        data.put(kategori.get(3), icon);

        return data;
    }
}
