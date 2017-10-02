package com.mercari.mercaritest.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mercari.mercaritest.BR;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.databinding.ActivityMainBinding;
import com.mercari.mercaritest.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>
        implements MainNavigator {

    private static final String CACHE_KEY = "CACHE_KEY";

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    MainAdapter adapter;

    @Inject
    GridLayoutManager gridLayoutManager;

    private MainViewModel mainViewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        mainViewModel.setNavigator(this);

        //todo fetch home data
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void updateItems(List<Item> items) {

    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
