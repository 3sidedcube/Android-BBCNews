package com.cube.bbcnews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * // TODO: Add class description
 *
 * @author Callum Taylor
 * @project BBCNews
 */
public class StoriesListFragment extends Fragment
{
	private ListView listView;

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

		listView.setAdapter(new StoriesAdapter(getActivity(), names));
	}
}
