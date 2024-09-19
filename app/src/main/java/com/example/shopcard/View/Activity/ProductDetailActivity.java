package com.example.shopcard.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shopcard.R;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView productImageDetails ,productSubImage;
    TextView productNameDetail,productPriceDetail ,productDescriptionDetail  ;
    Button  productOrderDetail ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        findView();

        Intent intent = getIntent();

        // Use the keys to extract the data
        int productId = intent.getIntExtra("PRODUCT_ID", -1);  // -1 is the default value if not found
        String productName = intent.getStringExtra("PRODUCT_NAME");
        double productPrice = intent.getDoubleExtra("PRODUCT_PRICE", 0.0);
        int productImage = intent.getIntExtra("PRODUCT_IMAGE",-1);


        productNameDetail.setText(productName);
        productPriceDetail.setText(productPrice+"/-");
        productImageDetails.setImageResource(productImage);



        productOrderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailActivity.this," order test",Toast.LENGTH_SHORT).show();
            }
        });




    }
    public  void findView(){
        productImageDetails=findViewById(R.id.productImageDetails);
        productSubImage =findViewById(R.id.productSubImage);
        productNameDetail =findViewById(R.id.productNameDetail);
        productPriceDetail = findViewById(R.id.productPriceDetail);
        productDescriptionDetail = findViewById(R.id.productDescriptionDetail);
        productOrderDetail = findViewById(R.id.productOrderDetail);


    }
}