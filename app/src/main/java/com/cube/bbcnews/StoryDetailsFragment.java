package com.cube.bbcnews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryDetailsFragment extends Fragment
{
	private ImageView featureImage;
	private TextView header;
	private TextView story;

	@Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.story_detail_view, container, false);

		featureImage = (ImageView)view.findViewById(R.id.feature_image);
		header = (TextView)view.findViewById(R.id.header);
		story = (TextView)view.findViewById(R.id.story);

		return view;
	}

	@Override public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		String name = getArguments().getString("name");
		header.setText(name);
	}
}
