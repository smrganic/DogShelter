package com.stjepanmrganic.adoptr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private List<String> ImageURLS = new ArrayList<>();
    private List<Address> Addresses = new ArrayList<>();
    private ClickListener boneListener, pawListener, profileListener;

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recycleItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecycleViewHolder(recycleItem, boneListener, pawListener, profileListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.setIvProfileImage(ImageURLS.get(position));
        holder.setTvName(Addresses.get(position).getName());
        holder.setTvAddress(Addresses.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return ImageURLS.size();
    }

    boolean isEmpty() { return ImageURLS.isEmpty(); }

    void setBoneListener(ClickListener boneListener) {
        this.boneListener = boneListener;
    }

    void setPawListener(ClickListener pawListener) {
        this.pawListener = pawListener;
    }

    void setProfileListener(ClickListener profileListener) { this.profileListener = profileListener; }

    void remove(int position) {
        ImageURLS.remove(position);
        notifyItemRemoved(position);
    }

    void attachImage(ProfileImage newData){
        ImageURLS.add(newData.getImageURL());
    }

    String getURL(int position) { return ImageURLS.get(position);}

    void attachAddress(Address newData) {
        Addresses.add(newData);
        notifyDataSetChanged();
    }

    String getName(int position) {
        return Addresses.get(position).getName();
    }

    void invalidateData() {
        ImageURLS.clear();
        Addresses.clear();
        notifyDataSetChanged();
    }

    public String getAddress(int position) {
        return Addresses.get(position).getAddress();
    }

    public String getWeigth(int position) {
        int weight = (Addresses.get(position).getWeight().intValue() / 5);
        return Integer.toString(weight);
    }

    public String getAge(int position) {
        String dateToParse = Addresses.get(position).getBirthData();
        dateToParse = dateToParse.substring(0, dateToParse.indexOf("-"));
        int date = Calendar.getInstance().get(Calendar.YEAR);
        int result = (date - Integer.parseInt(dateToParse)) / 7;
        return Integer.toString(result);
    }
}
