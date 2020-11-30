package org.secuso.privacyfriendlytodolist;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.secuso.privacyfriendlytodolist.view.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBackUnconditionally;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToDoListTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void createToDoListTest() {
        onView(withId(R.id.ac_add)).perform(click());

        onView(withId(R.id.et_todo_list_name)).perform(typeText("New To-Do list"), closeSoftKeyboard());
        onView(withId(R.id.bt_newtodolist_ok)).perform(click());

        onView(withId(R.id.clayout)).perform(swipeRight());
        onView(withId(R.id.nav_dummy1)).check(matches(is(withText("New To-Do list"))));
    }

    @Test
    public void createToDoTaskTest() {
        onView(withId(R.id.fab_new_task)).perform(click());

        onView(withId(R.id.et_new_task_name)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.et_new_task_description)).perform(typeText("321"), closeSoftKeyboard());
        onView(withId(R.id.tv_todo_list_deadline)).perform(click());
        onView(withId(R.id.bt_deadline_nodeadline)).perform(click());
        onView(withId(R.id.sb_new_task_progress)).perform(swipeRight());
        onView(withId(R.id.bt_new_task_ok)).perform(click());

        onView(withId(R.id.exlv_tasks)).check(matches(is(withText("123"))));

    }

    @Test
    public void setPINTest() {
        onView(withId(R.id.clayout)).perform(swipeRight());
        onView(withId(R.id.nav_settings)).perform(click());
        onView(withText("PIN required on startup")).perform(click());
        onView(withText("Set PIN")).perform(click()).perform(typeText("12345"), closeSoftKeyboard());
        onView(withId(R.id.bt_pin_ok)).perform(click());

        pressBackUnconditionally();
        activityScenarioRule.getScenario().close();
        activityScenarioRule.getScenario().recreate();

        onView(withId(R.id.et_pin_pin)).perform(typeText("12345"), closeSoftKeyboard());
        onView(withId(R.id.bt_pin_ok)).perform(click());
        onView(withId(R.id.fab_new_task)).check(matches(isDisplayed()));
    }

}
