package com.example.kaio_.entendotudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kaio_.entendotudo.Adapter.KaioAdapter;
import com.example.kaio_.entendotudo.Config.RetrofitConfig;
import com.example.kaio_.entendotudo.Config.Service;
import com.example.kaio_.entendotudo.Pojos.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    KaioAdapter kaioAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler);


        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<List<Posts>> call = service.getPosts();

        call.enqueue(new Callback<List<Posts>>() {


            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                configuradorRecyclervView(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }

    private void configuradorRecyclervView(List<Posts>postsList) {

        recyclerView = findViewById(R.id.recycler);
        kaioAdapter = new KaioAdapter(this,postsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kaioAdapter);
    }

}
