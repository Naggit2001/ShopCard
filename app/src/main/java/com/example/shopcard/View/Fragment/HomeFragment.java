package com.example.shopcard.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopcard.Controler.HomeFragmentController;
import com.example.shopcard.Model.ProductModel;
import com.example.shopcard.R;
import com.example.shopcard.View.Activity.ProductDetailActivity;

import java.util.List;

public class HomeFragment extends Fragment {

    private GridLayout homeList;
    private HomeFragmentController controller; // Reference to the controller

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Use fragment_home which should contain the GridLayout (not product_card)
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize the GridLayout view from the layout
        homeList = view.findViewById(R.id.homeList);

        // Initialize the controller, passing this fragment as the view
        controller = new HomeFragmentController(getContext(), this);

        // Load products and populate the GridLayout (controller handles business logic)
        controller.loadProducts();

        return view;
    }

    // Method to populate the GridLayout with product cards
    public void populateGridLayout(List<ProductModel> products) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (ProductModel product : products) {
            // Inflate the product card layout
            View cardView = inflater.inflate(R.layout.product_card, homeList, false);

            // Bind the product data to the view
            ImageView productImage = cardView.findViewById(R.id.cardImage);
            TextView productName = cardView.findViewById(R.id.cardTitle);
            TextView productPrice = cardView.findViewById(R.id.cardPay);

            // Set product details
            productImage.setImageResource(product.getImageResource());
            productName.setText(product.getName());
            productPrice.setText("$" + product.getPrice());

            // Add the populated card to the GridLayout
            homeList.addView(cardView);

             cardView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent = new Intent(getContext(), ProductDetailActivity.class);

                     intent.putExtra("PRODUCT_ID", product.getId());
                     intent.putExtra("PRODUCT_NAME", product.getName());
                     intent.putExtra("PRODUCT_PRICE", product.getPrice());
                     intent.putExtra("PRODUCT_IMAGE",product.getImageResource());

                     startActivity(intent);
                 }
             });
        }
    }
}
