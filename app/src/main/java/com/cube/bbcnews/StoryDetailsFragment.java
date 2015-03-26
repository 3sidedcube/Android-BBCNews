package com.cube.bbcnews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.callumtaylor.asynchttp.AsyncHttpClient;
import net.callumtaylor.asynchttp.response.BitmapResponseHandler;

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

		if (getArguments() != null)
		{
			Story story = (Story)getArguments().get("story");
			this.header.setText(story.getTitle());
			this.story.setText(story.getBody());

			new AsyncHttpClient(story.getImageURL())
				.get(new BitmapResponseHandler()
				{
					@Override public void onSuccess(){}

					@Override public void onFinish(boolean failed)
					{
						featureImage.setImageBitmap(getContent());
					}
				});
		}
		else
		{
			getActivity().finish();
		}
	}
}
