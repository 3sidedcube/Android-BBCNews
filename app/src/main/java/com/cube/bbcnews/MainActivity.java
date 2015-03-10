package com.cube.bbcnews;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

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
		}

		transaction.replace(R.id.fragment_holder, new StoriesListFragment());

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

		outState.putString("name", story);
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
			transaction.replace(R.id.fragment2_holder, fragment);
		}
		else
		{
			transaction.replace(R.id.fragment_holder, fragment).addToBackStack("story");
		}

		transaction.commit();
	}
}
