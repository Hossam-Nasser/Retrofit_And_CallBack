package com.example.ktapelwech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set data from same page
        Post post =new Post(5,"Hossam Nasser Fairoz","this is fris post");

        //set radome data
        HashMap<Object,Object> map= new HashMap<>();
        map.put("ueser name","ali new masssgae");
        map.put("passwer ","the last one");
        map.put("userId",6);

        textView = findViewById(R.id.post_titel_tv);

        //builer and converter and basic url
        Retrofit retrofit =new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //using interface
        AbiInterface abiInterface= retrofit.create(AbiInterface.class);

        //call for get data
        Call <Post>  call=abiInterface.getpost(1);

        //call for get data
        Call <List<Post>>  call=abiInterface.getpost("1");

        //call for get data
        Call <Post>  call=abiInterface.storePost(post);

        //call for set data
        Call <Post>  call=abiInterface.storePost(map);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                textView.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}
