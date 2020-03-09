package dev.ronnie.api;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = " https://api.the-odds-api.com/";
    private Data data;
    private RecyclerView recyclerView;
    private List<TeamList> list;
    private ApiInterface apiInterface;
    private String apiKey = "6eecad223784839864e6c3ac3abeb569";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new Data();
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

        getDataFromAApi();
    }

    private void getDataFromAApi() {

        apiInterface.getData(apiKey).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                if (response.body() != null) {
                    data = response.body();
                    list = data.data;
                    setupAdapter(list);
                    Toast.makeText(MainActivity.this, list.get(1).title, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

                Log.d("Error", "Error here " + t.getMessage());

            }
        });

    }

    private void setupAdapter(List<TeamList> list) {
        Adapter adapter = new Adapter(list, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
