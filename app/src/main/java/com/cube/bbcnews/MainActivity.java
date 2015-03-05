package com.cube.bbcnews;

import android.app.Activity;
import android.os.Bundle;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class MainActivity extends Activity
{
	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_view);

		getFragmentManager()
			.beginTransaction()
			.replace(R.id.fragment_holder, new StoriesListFragment())
			.commit();
	}
}
