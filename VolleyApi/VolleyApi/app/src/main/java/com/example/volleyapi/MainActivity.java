package com.example.volleyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.ConversationActions;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest stringRequest = new StringRequest(Request.Method.GET,Utils.API_URL,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VolleyAPI",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson =gsonBuilder.create();
                User user=gson.fromJson(response,User.class);
                recyclerView.setAdapter(new UserAdapter(MainActivity.this,user));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Something Went Wrong", Toast.LENGTH_LONG).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}