package com.stjepanmrganic.adoptr;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RecycleViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivProfileImage, ivBone, ivPaw;
    private TextView tvName, tvAddress;
    public RecycleViewHolder(@NonNull View itemView, final ClickListener boneListener, final ClickListener pawListener, final ClickListener ProfileListener) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        tvAddress = itemView.findViewById(R.id.tvAddress);
        ivBone = itemView.findViewById(R.id.ivBone);

        ivBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boneListener != null){
                    int position = getAdapterPosition();
                    boneListener.onItemClick(position);
                }
            }
        });

        ivPaw = itemView.findViewById(R.id.ivPaw);
        ivPaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pawListener != null){
                    int position = getAdapterPosition();
                    pawListener.onItemClick(position);
                }
            }
        });
        ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
        ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ProfileListener != null){
                    int position = getAdapterPosition();
                    ProfileListener.onItemClick(position);
                }
            }
        });
    }

    public void setIvProfileImage(String ivProfileImageURL) {
        Picasso.get().load(ivProfileImageURL).into(ivProfileImage);
    }

    public void setTvName(String tvName) {
        this.tvName.setText(tvName);
    }

    public void setTvAddress(String tvAddress) {
        this.tvAddress.setText(tvAddress);
    }
}
