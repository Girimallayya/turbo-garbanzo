package com.example.country.views;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.country.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotSame;

@RunWith(AndroidJUnit4.class)
public class CountryActivityTest {


    @Rule
    public ActivityTestRule<CountryActivity> activityTestRule = new ActivityTestRule<>(CountryActivity.class);

    @Test
    public void testRecyclerViewHasData() {
        if (getRecyclerViewCount() > 0) {
            onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        }
    }

    private int getRecyclerViewCount() {
        RecyclerView recyclerView = (RecyclerView) activityTestRule.getActivity().findViewById(R.id.recycler_view);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
        assertNotSame(0, recyclerView.getAdapter().getItemCount());
        return recyclerView.getAdapter().getItemCount();
    }
}