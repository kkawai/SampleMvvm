package com.mercari.mercaritest.ui.main;

import android.databinding.ObservableField;

import com.mercari.mercaritest.data.model.Item;

public class ItemViewModel {

    private static final String SOLD_OUT = "sold_out";

    public ObservableField<String> photoUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<Boolean> isSold = new ObservableField<>(false);

    private Item item;

    public ItemViewModel(Item item) {
        this.item = item;
        photoUrl.set(item.getPhoto());
        title.set(item.getName());
        price.set(item.getPrice()+"");
        if (item.getStatus() != null) {
            isSold.set(item.getStatus().equals(SOLD_OUT));
        }
    }

    public Item getItem() {
        return item;
    }
}
