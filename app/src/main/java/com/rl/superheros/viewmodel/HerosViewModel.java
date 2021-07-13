package com.rl.superheros.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rl.superheros.model.Api;
import com.rl.superheros.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HerosViewModel  extends ViewModel {


    private MutableLiveData<List<Hero>> heroList;


    public LiveData<List<Hero>> getHeros(){

        if (heroList == null){

            heroList = new MutableLiveData<List<Hero>>();
            loadHeros();
        }

        return heroList;
    }

    private void loadHeros(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
               .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Hero>> call = api.getHeros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {


            }
        });



    }





}
