package com.stjepanmrganic.adoptr;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private CardAdapter cardAdapter;
    private Call<ProfileImage> APICallDog;
    private Call<Address> APICallAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        runQ();
    }

    private void setupUI() {
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter();
        cardAdapter.setBoneListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                runQ();
            }
        });
        cardAdapter.setPawListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                runQ();
            }
        });
        cardAdapter.setProfileListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, AnimalDetails.class);
                intent.putExtra("IMAGE_URL", cardAdapter.getURL(position));
                intent.putExtra("ANIMAL_NAME", cardAdapter.getName(position));
                intent.putExtra("ADDRESS", cardAdapter.getAddress(position));
                intent.putExtra("AGE", cardAdapter.getAge(position));
                intent.putExtra("WEIGHT", cardAdapter.getWeigth(position));
                startActivity(intent);
            }
        });
        recycler.setAdapter(cardAdapter);
    }

    public void runQ() {
        if(!(cardAdapter.isEmpty())){
            cardAdapter.invalidateData();
        }

        APICallDog = DogAPI.getApiInterface().getProfileImage();
        APICallDogResponse();
    }

    private void APICallDogResponse() {
        APICallDog.enqueue(new Callback<ProfileImage>() {
            @Override
            public void onResponse(Call<ProfileImage> call, Response<ProfileImage> response) {
                if(response.isSuccessful()){
                    APICallAddress = AddressAPI.getApiInterface().getAddress();
                    APICallAddressResponse();
                    cardAdapter.attachImage(response.body());
                }
            }

            @Override
            public void onFailure(Call<ProfileImage> call, Throwable t) {
                runQ();
            }
        });
    }

    private void APICallAddressResponse() {
        APICallAddress.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {
                if(response.isSuccessful()){
                   cardAdapter.attachAddress(response.body());
                }
            }

            @Override
            public void onFailure(Call<Address> call, Throwable t) {
                runQ();
            }
        });
    }
}
