package com.cube.bbcnews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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

		View item = 

		return super.getView(position, convertView, parent);
	}
}
