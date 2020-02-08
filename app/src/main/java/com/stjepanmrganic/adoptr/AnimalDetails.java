package com.stjepanmrganic.adoptr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class AnimalDetails extends AppCompatActivity {

    private ImageView ivProfile;
    private TextView tvName, tvIndividualAddress, tvIndividualAge, tvIndividualWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        ivProfile = findViewById(R.id.ivIndividualProfile);
        String ivProfileImageURL = getIntent().getStringExtra("IMAGE_URL");
        Picasso.get().load(ivProfileImageURL).into(ivProfile);

        tvName = findViewById(R.id.tvIndividualName);
        tvName.setText(getIntent().getStringExtra("ANIMAL_NAME"));

        tvIndividualAddress = findViewById(R.id.tvIndividualAddress);
        tvIndividualAddress.setText(getIntent().getStringExtra("ADDRESS"));

        tvIndividualAge = findViewById(R.id.tvIndividualAge);
        tvIndividualAge.setText("Age: " + getIntent().getStringExtra("AGE") + " y");

        tvIndividualWeight = findViewById(R.id.tvIndividualWeight);
        tvIndividualWeight.setText("Weight: " + getIntent().getStringExtra("WEIGHT") + " kg");
    }
}
