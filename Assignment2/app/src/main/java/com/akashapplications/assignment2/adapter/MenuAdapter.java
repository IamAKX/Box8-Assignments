package com.akashapplications.assignment2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashapplications.assignment2.Menu;
import com.akashapplications.assignment2.R;
import com.akashapplications.assignment2.model.MenuModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    Context context;
    ArrayList<MenuModel> list;

    public MenuAdapter(Context context, ArrayList<MenuModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {

        Glide.with(context)
                .load(list.get(position).getImage())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.icon)
                        .error(R.drawable.icon))
                .into(holder.image);

        if(list.get(position).isVeg())
            holder.veg.setColorFilter(ContextCompat.getColor(context, R.color.veg), android.graphics.PorterDuff.Mode.MULTIPLY);
        else
            holder.veg.setColorFilter(ContextCompat.getColor(context, android.R.color.holo_red_dark), android.graphics.PorterDuff.Mode.MULTIPLY);

        holder.title.setText(list.get(position).getTitle());
        holder.desc.setText(list.get(position).getDescriptio());
        holder.amount.setText(list.get(position).getAmount());

        holder.qty.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Menu.cartQty += (newValue - oldValue);
                Menu.updateCart();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image, veg;
        TextView title, desc,amount;
        ElegantNumberButton qty;
        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            veg = itemView.findViewById(R.id.veg);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.description);
            amount = itemView.findViewById(R.id.amount);
            qty = itemView.findViewById(R.id.number_button);
        }
    }
}
