package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0, R.mipmap.pizza1, "35 min", "- 2 boneless skinless chicken breast halves...", "So fast and so easy...", "STEP 1: Sprinkle chicken..."));
        data.add(new Produit("BRUSCHETTA PIZZA", 5.0, R.mipmap.pizza2, "35 min", "- 1/2 pound pork sausage...", "Hearty pizza with Italian flavor.", "STEP 1: Cook sausage..."));
        data.add(new Produit("SPINACH PIZZA", 2.0, R.mipmap.pizza3, "25 min", "- Alfredo sauce, spinach...", "Tasty and veggie-filled.", "STEP 1: Prepare dough..."));
        data.add(new Produit("DEEP-DISH SAUSAGE PIZZA", 8.0, R.mipmap.pizza4, "45 min", "- Yeast, water, flour...", "Wonderful pizza from Grandma.", "STEP 1: Dissolve yeast..."));
        data.add(new Produit("HOMEMADE PIZZA", 4.0, R.mipmap.pizza5, "50 min", "- Beef, onion, tomato sauce...", "Hearty main dish.", "STEP 1: Dissolve yeast..."));
        data.add(new Produit("PESTO CHICKEN PIZZA", 3.0, R.mipmap.pizza6, "50 min", "- Pesto, chicken, peppers...", "Simple and healthy.", "STEP 1: Dissolve yeast..."));
        data.add(new Produit("LOADED MEXICAN PIZZA", 3.0, R.mipmap.pizza7, "30 min", "- Black beans, red onion...", "Healthy pizza with lots of flavor.", "STEP 1: Mash beans..."));
        data.add(new Produit("BACON CHEESEBURGER PIZZA", 2.0, R.mipmap.pizza8, "20 min", "- Beef, bacon, pickles...", "Kids love this version.", "STEP 1: Cook beef..."));
        data.add(new Produit("PIZZA MARGHERITA", 1.0, R.mipmap.pizza9, "30 min", "- Tomatoes, mozzarella, basil...", "Classic Italian colors.", "STEP 1: Dissolve yeast..."));
        data.add(new Produit("PEPPERONI-SAUSAGE STUFFED", 5.0, R.mipmap.pizza10, "45 min", "- Pepperoni, sausage, cheese...", "Freezes well.", "STEP 1: Dissolve yeast..."));
    }

    @Override public Produit create(Produit p) { data.add(p); return p; }
    @Override public List<Produit> findAll() { return Collections.unmodifiableList(data); }
    @Override public Produit findById(long id) {
        for (Produit p : data) if (p.getId() == id) return p;
        return null;
    }
    @Override public Produit update(Produit p) { return null; }
    @Override public boolean delete(long id) { return data.removeIf(x -> x.getId() == id); }
}