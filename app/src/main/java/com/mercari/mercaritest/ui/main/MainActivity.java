package com.mercari.mercaritest.ui.main;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.databinding.ActivityMainBinding;
import com.mercari.mercaritest.ui.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements MainNavigator {

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void updateItems(List<Item> items) {

    }

    @Override
    public MainViewModel getViewModel() {
        return null;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
