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
		transaction.replace(R.id.fragment_holder, new StoriesListFragment());

		transaction.commit();
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
