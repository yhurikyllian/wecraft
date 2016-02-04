package id.wecraft.service;

import java.util.List;

import org.apache.http.client.methods.AbortableHttpRequest;

import com.etsy.android.grid.StaggeredGridView;

import id.wecraft.R;
import id.wecraft.model.Company;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

public class ProductProfile extends Fragment {

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	//public static final String ARG_SECTION_NUMBER = "section_number";
	
	
	private Company company;
	private StaggeredGridView mGridView;
    //private boolean mHasRequestedMore;
    private ProductAdapter mAdapter;
    private String url;
    private Context context;
    private FragmentManager fm;
	
	public ProductProfile(FragmentManager fm, Context context, Company company, String url) {
		this.fm = fm;
		this.context = context;
		this.company = company;
		this.url = url;
	}
	
	@Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.product_profile_item, container, false);
		//TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
		//dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
		mGridView = (StaggeredGridView) rootView.findViewById(R.id.grid_view);
		List<Company.Products> products = company.getProduct();
		mAdapter = new ProductAdapter(context, R.layout.product_profile_item_list, products, url);
		//mAdapter.addAll(products);
		mGridView.setAdapter(mAdapter);
		return rootView;
	}
	

	/*@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}*/
	
	//old-sample
	/*private void sample1(View rootView) {
		mGridView = (StaggeredGridView) rootView.findViewById(R.id.grid_view);

        if (mAdapter == null) {
            mAdapter = new ProductAdapter(context, R.layout.product_profile_item_list, company.getProduct(), url);
        }
        //fm.executePendingTransactions();
        //fm.beginTransaction().add(android.R.id.content, this).commit();
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
	}*/
}
