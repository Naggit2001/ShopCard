package com.example.shopcard.View.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopcard.R;

import java.util.HashMap;
import java.util.Map;


public class CardFragment extends Fragment {

    private final static String url = "https://toolsbuzz.com/contactdata";  // Use 10.0.2.2 for localhost in emulator
    TextView textview;

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        EditText name = view.findViewById(R.id.contactname);
        EditText email = view.findViewById(R.id.contactemail);
        textview = view.findViewById(R.id.textcard);
        Button button = view.findViewById(R.id.cardbutton);
        textview.setText("hello bro");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processData(name.getText().toString(), email.getText().toString());
            }
        });

        return view;
    }

    private void processData(String name, String email) {

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textview.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                textview.setText("Error: " + error.getMessage());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("email", email);
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}
