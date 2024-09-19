package com.example.shopcard.Controler;

import android.content.Context;
import android.widget.ListView;

import com.example.shopcard.Model.ProductModel;
import com.example.shopcard.R;
import com.example.shopcard.View.Fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentController {
    private Context context;
    private HomeFragment homeFragment;


    public HomeFragmentController(Context context, HomeFragment homeFragment) {
        this.context = context;
        this.homeFragment = homeFragment;
    }


    public  void  loadProducts(){
        List<ProductModel> products = new ArrayList<>();
        homeFragment.populateGridLayout(getProduct());

    }


    public List<ProductModel> getProduct(){
        List<ProductModel> products = new ArrayList<>();
        products.add(new ProductModel(1,"Product 1", "Description 1", 29.99, R.drawable.laptop3d));
        products.add(new ProductModel(2,"Product 2", "Description 2", 39.99, R.drawable.security));
        products.add(new ProductModel(3,"Product 3", "Description 3", 19.99, R.drawable.laptop3d));
        products.add(new ProductModel(4,"Product 4", "Description 4", 49.99, R.drawable.wellcomeimage));
        products.add(new ProductModel(5,"Product 1", "Description 1", 29.99, R.drawable.laptop3d));
        products.add(new ProductModel(6,"Product 2", "Description 2", 39.99, R.drawable.security));
        products.add(new ProductModel(7,"Product 3", "Description 3", 19.99, R.drawable.laptop3d));
        products.add(new ProductModel(8,"Product 4", "Description 4", 49.99, R.drawable.wellcomeimage));


        return  products;


    }
}
