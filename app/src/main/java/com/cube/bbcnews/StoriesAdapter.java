package com.cube.bbcnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class StoriesAdapter extends ArrayAdapter<String>
{
	public StoriesAdapter(Context context, String[] objects)
	{
		super(context, android.R.layout.simple_list_item_1, objects);
	}

	@Override public View getView(int position, View convertView, ViewGroup parent)
	{
		String name = getItem(position);

		View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_list_item, parent, false);
		TextView title = (TextView)item.findViewById(R.id.title);

		title.setText(name);

		return item;
	}
}
