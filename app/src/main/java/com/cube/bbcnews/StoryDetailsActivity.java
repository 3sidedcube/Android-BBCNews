package com.cube.bbcnews;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class StoryDetailsActivity extends Activity
{
	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_holder_view);

		String name = getIntent().getExtras().getString("name");

		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_holder, new StoryDetailsFragment());
		transaction.commit();
	}
}
