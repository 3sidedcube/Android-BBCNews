package com.cube.bbcnews;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class MainActivity extends Activity
{
	private String story;

	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_view);

		FragmentTransaction transaction = getFragmentManager().beginTransaction();

		// If the device has orientated, savedInstanceState will not be null. it will only ever be
		// null if the activity has started for the very first time
		if (savedInstanceState != null)
		{
			// get our story back from the instance
			this.story = savedInstanceState.getString("name");

			if (!TextUtils.isEmpty(story))
			{
				selectStory(story);
			}

			// We always want the fragment_holder to be the list if fragment2_holder exists
			if (findViewById(R.id.fragment2_holder) != null)
			{
				transaction.replace(R.id.fragment_holder, new StoriesListFragment());
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			}
		}
		else
		{
			// If we're in landscape mode, nothing will be in fragment_holder, so we need to populate it
			// but if we're in portrait mode and a story has been selected, it will, and if no story has
			// been selected, it will also be null, so populate it again
			if (getFragmentManager().findFragmentByTag("story") == null)
			{
				transaction.replace(R.id.fragment_holder, new StoriesListFragment());
			}
		}

		transaction.commit();
	}

	/**
	 * this method is called when the activity is destroyed so you can retain any variable on rotation.
	 * We're going to use this so we remember what story (if any) was selected. It uses the same Bundle
	 * class that we've used before.
	 *
	 * @param outState
	 */
	@Override protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);

		// we dont want to pass the story through if we're no longer reading a story, so we need to do
		// a check. We can do that by tagging our fragment and then checking if its still available
		// when this method is called via that tag. We use tag because we don't know what fragment_holder
		// the fragment will live in
		if (getFragmentManager().findFragmentByTag("story") != null)
		{
			outState.putString("name", story);
		}
	}

	public void selectStory(String story)
	{
		this.story = story;

		FragmentTransaction transaction = getFragmentManager().beginTransaction();

		Bundle extras = new Bundle();
		extras.putString("name", story);

		StoryDetailsFragment fragment = new StoryDetailsFragment();
		fragment.setArguments(extras);

		if (findViewById(R.id.fragment2_holder) != null)
		{
			transaction.replace(R.id.fragment2_holder, fragment, "story");
		}
		else
		{
			// we need to change backstack tag to null because we dont want it to get confused with our
			// tagging system for our instance state checking
			transaction.replace(R.id.fragment_holder, fragment, "story").addToBackStack(null);
		}

		transaction.commit();
	}
}
