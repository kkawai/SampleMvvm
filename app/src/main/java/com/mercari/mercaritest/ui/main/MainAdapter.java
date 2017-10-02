package com.mercari.mercaritest.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mercari.mercaritest.databinding.ItemBinding;
import com.mercari.mercaritest.ui.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ItemViewModel> list = new ArrayList<>();

    public MainAdapter(){}

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateItems(List<ItemViewModel> photos) {
        list.clear();
        list.addAll(photos);
        notifyItemRangeInserted(0,photos.size());
    }

    class ItemViewHolder extends BaseViewHolder {
        ItemBinding binding;
        public ItemViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            ItemViewModel itemViewModel = list.get(position);
            binding.setViewModel(itemViewModel);
            binding.executePendingBindings();
        }
    }
}
