package com.globant.mvvm;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void initialSetUp() {
        //check add button present or not
        Espresso.onView(withId(R.id.floatingActionButton)).check(ViewAssertions.matches(isDisplayed()));
        //perform click on button
        Espresso.onView(withId(R.id.floatingActionButton)).perform(ViewActions.click());
    }

    @Test
    public void registerUser_Test() {

        //check neccessary input fields are there or not
        Espresso.onView(withId(R.id.first_name)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.last_name)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.mobile_no)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.email)).check(ViewAssertions.matches(isDisplayed()));


        // Type first name and check last name enabled or not
        onView(withId(R.id.last_name)).check(ViewAssertions.matches(Matchers.not(isEnabled())));
        Espresso.onView(ViewMatchers.withId(R.id.first_name))
                .perform(ViewActions.typeText("Mahesh"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.last_name)).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
        Espresso.onView(withId(R.id.save)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())));

        // Type last name and check mobile no enabled or not
        onView(withId(R.id.mobile_no)).check(ViewAssertions.matches(Matchers.not(isEnabled())));
        Espresso.onView(ViewMatchers.withId(R.id.last_name))
                .perform(ViewActions.typeText("Chakkarwar"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.mobile_no)).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
        Espresso.onView(withId(R.id.save)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())));

        // Type mobile no and check email enabled or not
        onView(withId(R.id.email)).check(ViewAssertions.matches(Matchers.not(isEnabled())));
        Espresso.onView(ViewMatchers.withId(R.id.mobile_no))
                .perform(ViewActions.typeText("9665866523"), ViewActions.closeSoftKeyboard());
        Espresso.onView(withId(R.id.email)).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
        Espresso.onView(withId(R.id.save)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())));

        // Type email and check save enabled or not
        onView(withId(R.id.save)).check(ViewAssertions.matches(Matchers.not(isEnabled())));
        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("mahesh.chakkarwar@globant.com"), ViewActions.closeSoftKeyboard());
//        Espresso.onView(withId(R.id.save)).check(ViewAssertions.matches(ViewMatchers.isEnabled()));
        Espresso.onView(withId(R.id.save)).perform(ViewActions.click());
    }
}
