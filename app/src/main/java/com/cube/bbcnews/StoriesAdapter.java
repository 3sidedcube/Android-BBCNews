package com.cube.bbcnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class StoriesAdapter extends BaseAdapter
{
	private Story[] items;

	public StoriesAdapter(Story[] objects)
	{
		this.items = objects;
	}

	@Override public View getView(int position, View convertView, ViewGroup parent)
	{
		Story story = getItem(position);
		StoryHolder holder;

		if (convertView == null)
		{
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_list_item, parent, false);

			holder = new StoryHolder();
			holder.title = (TextView)convertView.findViewById(R.id.title);
			holder.subtitle = (TextView)convertView.findViewById(R.id.subtitle);

			convertView.setTag(holder);
		}
		else
		{
			holder = (StoryHolder)convertView.getTag();
		}

		holder.title.setText(story.getTitle());
		holder.subtitle.setText(story.getBody());

		return convertView;
	}

	@Override public int getCount()
	{
		return items.length;
	}

	@Override public Story getItem(int position)
	{
		return items[position];
	}

	@Override public long getItemId(int position)
	{
		return items[position].hashCode();
	}
}
