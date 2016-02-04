package id.wecraft.service;

import com.bluejamesbond.text.DocumentView;
import com.squareup.picasso.Picasso;

import id.wecraft.CommonSetting;
import id.wecraft.R;
import id.wecraft.model.Company;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyProfile extends Fragment implements CommonSetting{

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	//public static final String ARG_SECTION_NUMBER = "section_number";
	private Company company;
	private Context context;

	public CompanyProfile(Context context, Company company) {
		this.context = context;
		this.company = company;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.company_profile_item,	container, false);
		//TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
		//dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
		ViewHolder holder = new ViewHolder();
		holder.name = (TextView) rootView.findViewById(R.id.profile_company_name);
		holder.contact = (TextView) rootView.findViewById(R.id.profile_company_contact);
		holder.address = (TextView) rootView.findViewById(R.id.profile_company_address);
		//holder.desc = (TextView) rootView.findViewById(R.id.profile_company_description);
		holder.desc = (DocumentView) rootView.findViewById(R.id.profile_company_description);
		holder.logo = (ImageView) rootView.findViewById(R.id.profile_logo);
		
		if(company != null) {
			holder.name.setText(company.getName());
			
			String cHp = "";
			String cBbm = "";
			
			if(!company.getContact().getHp().equals("")) {
				cHp = "Telpon : " + company.getContact().getHp();
			}
			if(!company.getContact().getBbm().equals("")) {
				cBbm = " \nBBM : " + company.getContact().getBbm();
			}
			
			String contact = cHp + cBbm; 
			holder.contact.setText(contact);
			holder.address.setText(company.getAddress());
			 
			holder.desc.setText(company.getDescription());
			holder.desc.setFadeInDuration(800);
			holder.desc.setFadeInAnimationStepDelay(30);
			holder.desc.setFadeInTween(new DocumentView.ITween() {
	            @Override
	            public float get(float t, float b, float c, float d) {
	                return c * (t /= d) * t * t + b;
	            }
	        });
			
			if(holder.logo != null) {
				String URL = "";
				if(company.getTag().equals("batik")) {
					URL = BATIK_ENDPOINT;
				} else if(company.getTag().equals("furnitur")) {
					URL = FURNITUR_ENDPOINT;
				} else if(company.getTag().equals("hiasdandekor")) {
					URL = HIASAN_DAN_DEKORASI_ENDPOINT;
				} else if(company.getTag().equals("perhiasandanaksesoris")) {
					URL = PERHIASAN_DAN_AKSESORIS_ENDPOINT;
				}
        		Picasso.with(context).load(URL + company.getLogo()).resize(180, 180).centerCrop().into(holder.logo);
        	}
		}
		
		return rootView;
	}
	
	static class ViewHolder {
		ImageView logo;
		TextView name;
		TextView contact;
		TextView address;
		//TextView desc;
		DocumentView desc;
	}
}
