package com.cube.bbcnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.callumtaylor.asynchttp.AsyncHttpClient;
import net.callumtaylor.asynchttp.response.BitmapResponseHandler;

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

	public void setItems(Story[] items)
	{
		this.items = items;
	}

	@Override public View getView(int position, View convertView, ViewGroup parent)
	{
		Story story = getItem(position);
		final StoryHolder holder;

		if (convertView == null)
		{
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_list_item, parent, false);

			holder = new StoryHolder();
			holder.title = (TextView)convertView.findViewById(R.id.title);
			holder.subtitle = (TextView)convertView.findViewById(R.id.subtitle);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);

			convertView.setTag(holder);
		}
		else
		{
			holder = (StoryHolder)convertView.getTag();
		}

		holder.title.setText(story.getTitle());
		holder.subtitle.setText(story.getBody());

		holder.icon.setImageBitmap(null);

		if (holder.icon.getTag() != null)
		{
			((AsyncHttpClient)holder.icon.getTag()).cancel();
		}

		AsyncHttpClient client = new AsyncHttpClient(story.getImageURL());
		client.get(new BitmapResponseHandler()
		{
			@Override public void onSuccess(){}

			@Override public void onFinish(boolean failed)
			{
				holder.icon.setTag(null);
				holder.icon.setImageBitmap(getContent());
			}
		});

		holder.icon.setTag(client);

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
