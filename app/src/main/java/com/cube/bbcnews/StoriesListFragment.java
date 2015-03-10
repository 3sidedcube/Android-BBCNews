package com.cube.bbcnews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class StoriesListFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
	private ListView listView;
	private StoriesAdapter adapter;

	@Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.stories_list_view, container, false);
		listView = (ListView)view.findViewById(R.id.list_view);

		return view;
	}

	@Override public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		String[] names = {
			"Callum",
			"Ollie",
			"Steve",
			"Tim",
			"Matt",
			"Matt C",
			"Keisha",
			"Duncan",
			"Jess",
			"Sam",
			"Simon",
			"Dan",
			"Puff",
			"Sophie",
			"Imogen"
		};

		adapter = new StoriesAdapter(names);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
	}

	@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		if (getActivity() instanceof MainActivity)
		{
			((MainActivity)getActivity()).selectStory(adapter.getItem(position));
		}

//		Intent details = new Intent(getActivity(), StoryDetailsActivity.class);
//		details.putExtra("name", adapter.getItem(position));
//		startActivity(details);
	}

	@Override public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(getActivity(), String.format("Item %s was long clicked!", position), Toast.LENGTH_LONG).show();
		return true;
	}
}
