package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testAddCity() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Edmonton")).check(matches(withText("Edmonton")));
    }


    @Test
    public void testClearCities() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Calgary"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withId(R.id.button_clear)).perform(click());

        onView(withText("Edmonton")).check(doesNotExist());
        onView(withText("Calgary")).check(doesNotExist());
    }


    @Test
    public void testFirstItemIsEdmonton() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(replaceText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .check(matches(withText("Edmonton")));
    }
}