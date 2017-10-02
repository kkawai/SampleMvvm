package com.mercari.mercaritest.ui.main;

import android.databinding.ObservableField;

import com.mercari.mercaritest.data.model.Item;

public class ItemViewModel {
    public ObservableField<String> photoUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<Boolean> isSold = new ObservableField<>(false);

    private Item item;

    public ItemViewModel(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
