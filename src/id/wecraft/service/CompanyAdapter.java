package id.wecraft.service;


import id.wecraft.CompanyActivity;
import id.wecraft.ProfileActivity;
import id.wecraft.R;
import id.wecraft.model.Company;

import java.util.List;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CompanyAdapter extends ArrayAdapter<Company>{

	String url="";
    private Context context;
    private List<Company> companyList;
    private LayoutInflater inflater;
    private ViewHolder holder;
    private Company c;
    
    public CompanyAdapter(Context context, int resource, List<Company> companyList, String url) {
    	super(context, resource, companyList);
    	this.context = context;
    	this.companyList = companyList;
    	this.url = url;
    	inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	
    	View v = convertView;
    	holder = new ViewHolder();
    	
    	if(v == null) {    		
    		v = inflater.inflate(R.layout.company_list, parent, false);
    		holder.name = (TextView) v.findViewById(R.id.title);
    		//holder.rating = (TextView) v.findViewById(R.id.rating);
    		holder.city = (TextView) v.findViewById(R.id.city);
    		holder.logo = (ImageView) v.findViewById(R.id.img);
    	}
    	
    	c = companyList.get(position);
    	if(c != null) {
    		
    		if(holder.name != null) {
    			System.out.println("no null");
    			holder.name.setText(c.getName());
    		}
    		
    		if(holder.city != null) {
    			holder.city.setText(c.getCity());
    		}
    		
    		/*String rate;
    		switch(c.getRating()) {
    		case 1:
    			rate = "Gold";
    			break;
    		case 2:
    			rate = "Platinum";
    			break;
    		case 3:
    			rate = "Diamond";
    			break;
    		default :
    			rate = "Error";
    			break;
    		}
    		if(holder.rating != null) {
    			holder.rating.setText(rate);
    		}*/
        	
        	if(holder.logo != null) {
        		Picasso.with(context).load(url + c.getLogo()).resize(70, 70).centerCrop().into(holder.logo);
        	}
    	}
    	
    	return v;
    }
    
    public Company getCompany(int pos) {
    	Company c = companyList.get(pos);
    	return c;
    }
    
    static class ViewHolder {
    	TextView name;
    	//TextView rating;
    	TextView city;
    	ImageView logo;
    	ListView listView;
    }
}
