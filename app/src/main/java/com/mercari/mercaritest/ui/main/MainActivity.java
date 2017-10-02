package com.mercari.mercaritest.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

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
        mainViewModel.fetchHomeData(fromCache(savedInstanceState));
    }

    private List<Item> fromCache(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(CACHE_KEY)) {
            return savedInstanceState.getParcelableArrayList(CACHE_KEY);
        }
        return null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mainViewModel.list.size() > 0) {
            outState.putParcelableArrayList(CACHE_KEY, mainViewModel.convert());
        }
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(this,R.string.error_message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateItems(List<Item> items) {
        mainViewModel.populateViewModel(items);
        adapter.updateItems(mainViewModel.list);
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
