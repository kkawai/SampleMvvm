package com.mercari.mercaritest.ui.main;

import com.mercari.mercaritest.data.model.Item;

import java.util.List;

public interface MainNavigator {
    void handleError(Throwable throwable);
    void updateItems(List<Item> items);
}
