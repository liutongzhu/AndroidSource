package com.sogou.gamemall.activity;

import com.sogou.gamemall.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class IndexAFragment extends Fragment {
	public static final String TAG = IndexAFragment.class.getSimpleName();

	public static IndexAFragment newInstance() {
		return new IndexAFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("debug", "IndexAFragment--onCreate");
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("debug", "IndexAFragment--onCreateView");
		return inflater.inflate(R.layout.indexa_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ViewPager mViewPager = (ViewPager) view
				.findViewById(R.id.indexa_fragment_viewPager);
		mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
	}

	static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public Fragment getItem(int position) {
			// Bundle args = new Bundle();
			// args.putInt(TextViewFragment.POSITION_KEY, position);
			return PageFragment.newInstance(position + 1);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Fragment # " + position;
		}

	}
}
