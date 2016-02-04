package id.wecraft.service;

import id.wecraft.R;
import id.wecraft.model.Company;

import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ProfileTabPagerAdapter extends FragmentPagerAdapter{

	private Context context;
	private Company company;
	private String url;
	private FragmentManager fm;
	
	public ProfileTabPagerAdapter(FragmentManager fm, Context context, Company company, String url) {
		super(fm);
		this.fm = fm;
		this.context = context;
		this.company = company;
		this.url = url;
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a DummySectionFragment (defined as a static inner class
		// below) with the page number as its lone argument.
		/*Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		return fragment;*/
		
		switch(position) {
		case 0:
			return new CompanyProfile(context, company);
		case 1:			
			/*ProductProfile fragment = null;
			if (fm.findFragmentById(android.R.id.content) == null) {
				fragment = new ProductProfile(fm, context, company, url);
				fm.executePendingTransactions();
				fm.beginTransaction().add(android.R.id.content, fragment).commit();
				//fm.beginTransaction().remove(fragment).commit();
				//fm.executePendingTransactions();
				//fm.beginTransaction().add(android.R.id.content, fragment).commit();
				System.out.println("R.id.content : " + android.R.id.content);
				//FragmentTransaction ft = fm.beginTransaction();
				//ft.add(android.R.id.content, fragment);
				//ft.commit();
				//ft.remove(fragment);
				//fm.executePendingTransactions();
				//ft.commit();
				//Fragment newInstance = recreateFragment(fragment);
				
				//ft.add(android.R.id.content, fragment);
				//ft.commit();
				/*fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				fm.beginTransaction().remove(fragment).commit();
				fm.executePendingTransactions();
				fm.beginTransaction().add(android.R.id.content, fragment).commit();*/
			//}
			return new ProductProfile(fm, context, company, url);
		}
		return null;
	}

	@Override
	public int getCount() {
		// Show 2 total pages.
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return context.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return context.getString(R.string.title_section2).toUpperCase(l);
		}
		return null;
	}
}
