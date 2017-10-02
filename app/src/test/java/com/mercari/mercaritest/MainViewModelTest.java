package com.mercari.mercaritest;

import com.mercari.mercaritest.data.DataManager;
import com.mercari.mercaritest.data.model.HomeResponse;
import com.mercari.mercaritest.ui.main.MainNavigator;
import com.mercari.mercaritest.ui.main.MainViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {

    @Mock
    MainNavigator mainNavigator;
    @Mock
    DataManager dataManager;

    private MainViewModel mainViewModel;
    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(testScheduler);
        mainViewModel = new MainViewModel(
                dataManager,
                testSchedulerProvider);
        mainViewModel.onViewCreated();
        mainViewModel.setNavigator(mainNavigator);
    }

    @Test
    public void testGetPhotos() {

        HomeResponse homeResponse = new HomeResponse();

        doReturn(Observable.just(homeResponse))
                .when(dataManager)
                .getHomeData();

        mainViewModel.fetchHomeData(null);

        testScheduler.triggerActions();

        verify(mainNavigator).updateItems(homeResponse.getItems());
    }

    @After
    public void tearDown() throws Exception {
        mainViewModel.onDestroyView();
    }

}
