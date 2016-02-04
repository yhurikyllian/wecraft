package id.wecraft.service;

import id.wecraft.R;
import id.wecraft.model.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;
import com.squareup.picasso.Picasso;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductAdapter extends ArrayAdapter<Company.Products>{
	
	private static final String TAG = "ProductAdapter";
	
	private final LayoutInflater mLayoutInflater;
	//private final ArrayList<String> mBackgroundImages;
	private final Random mRandom;
	private List<Company.Products> products;
	private Context context;
	private String url;
	
	private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

	public ProductAdapter(Context context, int textViewResourceId, List<Company.Products> products, String url) {
		super(context, textViewResourceId, products);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.products = products;
		this.url = url;
		mLayoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		//mBackgroundImages = new ArrayList<String>();
		mRandom = new Random();
	}
	
	@Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
		View row = convertView;
		final ViewHolder holder;
		
		if(row == null) {
			row = mLayoutInflater.inflate(R.layout.product_profile_item_list, parent, false);
			
			holder = new ViewHolder();
			holder.title = (TextView) row.findViewById(R.id.product_title);
            holder.imgProducts = (DynamicHeightImageView) row.findViewById(R.id.product_img);
            row.setTag(holder);
		} else {
			holder = (ViewHolder) row.getTag();
		}
		
		double positionHeight = getPositionRatio(position);
		int posHeight = (int) (200 * positionHeight);
		final Company.Products product = products.get(position);
		if(product != null) {
			holder.imgProducts.setHeightRatio(positionHeight);
			holder.title.setText(product.getpName());
            Picasso.with(context).load(url + product.getpImage()).resize(200, posHeight).centerCrop().into(holder.imgProducts);
		}
		return row;
    }
	
	private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }
	
	private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }
	
	static class ViewHolder {
		TextView title;
		DynamicHeightImageView imgProducts;
	}
}
