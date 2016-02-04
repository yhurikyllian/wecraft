package id.wecraft.service;

import id.wecraft.CategoryActivity;
import id.wecraft.CompanyActivity;
import id.wecraft.R;
import id.wecraft.model.Category;

import java.util.List;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CategoryAdapter extends ArrayAdapter<Category>{

	private List<Category> categories;
	private LayoutInflater layoutInflater;
	private Context context;
	
	public CategoryAdapter(Context context, int textViewResourceId, List<Category> list) {
		super(context, textViewResourceId, list);
		this.context = context;
		this.categories = list;
		//layoutInflater = LayoutInflater.from(context);
		layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		if (v == null) {
			v = layoutInflater.inflate(R.layout.category_list, parent, false);
		}
		
		final Category cat = categories.get(position);
		if (cat != null) {
			ImageView img = (ImageView) v.findViewById(R.id.img_category);
			if (img != null) {
				//lebih cepet setimageresource
				//img.setImageResource(cat.getImg());
				Picasso.with(context).load(cat.getImg()).into(img);
			}
				img.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(context, CompanyActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra("category", cat.getName());
					System.out.println("category name : " + cat.getName());
					context.startActivity(intent);
				}
			});
		}
		
		return v;
	}
	
	
}
