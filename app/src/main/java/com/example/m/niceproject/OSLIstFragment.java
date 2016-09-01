package com.example.m.niceproject;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OSLIstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OSLIstFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment OSLIstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OSLIstFragment newInstance() {
        OSLIstFragment fragment = new OSLIstFragment();
        return fragment;
    }

    public OSLIstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView = inflater.inflate(R.layout.fragment_oslist, container, false);

        String[] values = new String[] { "Android", "iPhone", "Windows Phone 8", "Blackberry", "WebOS",  };
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final ListView listview = (ListView)  fragmentView.findViewById(R.id.listview);
        final OSArrayAdapter adapter = new OSArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        return fragmentView;
    }

}



class OSArrayAdapter extends ArrayAdapter<String>
{
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();
    public OSArrayAdapter(Context context, int textViewResourceId,
                          List<String> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    public boolean hasStableIds() {
        return true;
    }
}
