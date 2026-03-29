package com.example.mystars.services;

import com.example.mystars.database.ICrud;
import com.example.mystars.models.Celebrity;
import com.example.mystars.R;
import java.util.ArrayList;
import java.util.List;

public class CelebrityService implements ICrud<Celebrity> {
    private List<Celebrity> celebrities;
    private static CelebrityService instance;

    private CelebrityService() {
        celebrities = new ArrayList<>();
        fillData();
    }

    public static CelebrityService getInstance() {
        if (instance == null) {
            instance = new CelebrityService();
        }
        return instance;
    }

    private void fillData() {
        // Remplacez les R.drawable.xxx par vos propres noms d'images
        // Placez vos fichiers .png dans res/drawable/ (ex: zendaya.png, ryan_reynolds.png...)
        celebrities.add(new Celebrity("Zendaya", R.drawable.zendaya, 4.7f));
        celebrities.add(new Celebrity("Ryan Reynolds", R.drawable.ryan_reynolds, 4.5f));
        celebrities.add(new Celebrity("Margot Robbie", R.drawable.margot_robbie, 4.9f));
        celebrities.add(new Celebrity("Keanu Reeves", R.drawable.keanu_reeves, 4.8f));
    }

    @Override
    public boolean add(Celebrity item) {
        return celebrities.add(item);
    }

    @Override
    public boolean update(Celebrity item) {
        for (int i = 0; i < celebrities.size(); i++) {
            if (celebrities.get(i).getId() == item.getId()) {
                celebrities.set(i, item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Celebrity item) {
        return celebrities.remove(item);
    }

    @Override
    public Celebrity findById(int id) {
        for (Celebrity c : celebrities) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Celebrity> getAll() {
        return new ArrayList<>(celebrities);
    }
}