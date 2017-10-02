package com.mercari.mercaritest.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mercari.mercaritest.Config;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.databinding.ItemBinding;
import com.mercari.mercaritest.ui.base.BaseViewHolder;
import com.mercari.mercaritest.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ItemViewModel> list = new ArrayList<>();

    private int screenWidth;
    private int sideMargin;

    public MainAdapter(Context context){

        screenWidth = ScreenUtils.getScreenWidth(context);
        sideMargin = context.getResources().getDimensionPixelSize(R.dimen.item_horizontal_margin);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent, false);
        calcSizes(binding);
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

    public void updateItems(List<ItemViewModel> items) {
        list.clear();
        list.addAll(items);
        notifyItemRangeInserted(0,items.size());
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

    /**
     * Dynamically calculate item sizes based on #columns and screen width.
     *
     * @param binding
     */
    private void calcSizes(ItemBinding binding) {
        int imageSize = (screenWidth / Config.GRID_COLUMNS) - sideMargin;
        float soldSize = imageSize * .40f;
        binding.imageView.getLayoutParams().height = imageSize;
        binding.imageView.getLayoutParams().width = imageSize;
        binding.soldView.getLayoutParams().height = (int)soldSize;
        binding.soldView.getLayoutParams().width = (int)soldSize;
    }
}
