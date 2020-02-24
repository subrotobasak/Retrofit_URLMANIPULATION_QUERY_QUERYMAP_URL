package com.example.retrofit_urlmanipulation_query_querymap_url.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit_urlmanipulation_query_querymap_url.Adapter.UserAdapter;
import com.example.retrofit_urlmanipulation_query_querymap_url.Interface.ApiInterface;
import com.example.retrofit_urlmanipulation_query_querymap_url.Model.Model;
import com.example.retrofit_urlmanipulation_query_querymap_url.R;
import com.example.retrofit_urlmanipulation_query_querymap_url.Retrofit.ApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<Model> models;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
    }

    private void getData() {
        //Use @QueryMap
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_short", "id");
        parameters.put("_order", "desc");

        apiInterface = ApiClient.getInstance().getApi();

        //Use simple @Query
//        Call<List<Model>> call = apiInterface.getAllData(2);

        // Use @Query Advance
//        Call<List<Model>> call = apiInterface.getAllData(new Integer[]{2,4,6},null,null);


        //Use @QueryMap
        Call<List<Model>> call = apiInterface.getAllData(parameters);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                models = response.body();
                userAdapter = new UserAdapter(models);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void init() {
        recyclerView = findViewById(R.id.userRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models = new ArrayList<>();


    }
}

