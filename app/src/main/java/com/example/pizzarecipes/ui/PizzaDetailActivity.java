package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        if (p != null) {
            ((ImageView)findViewById(R.id.img)).setImageResource(p.getImageRes());
            ((TextView)findViewById(R.id.title)).setText(p.getNom());
            ((TextView)findViewById(R.id.meta)).setText(p.getDuree() + " • " + p.getPrix() + " €");
            ((TextView)findViewById(R.id.ingredients)).setText(p.getIngredients());
            ((TextView)findViewById(R.id.desc)).setText(p.getDescription());
            ((TextView)findViewById(R.id.steps)).setText(p.getEtapes());
        }
    }
}