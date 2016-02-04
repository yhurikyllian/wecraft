package id.wecraft;

import id.wecraft.model.Company;
import id.wecraft.network.Api;
import id.wecraft.service.CategoryAdapter;
import id.wecraft.service.CompanyAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Log;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CompanyActivity extends ListActivity implements CommonSetting{

	private CompanyAdapter adapter;
	private List<Company> companyList;
	private Api api;
	private String URL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company);
		
		connectToJson();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.company, menu);
		return true;
	}
	
	public void connectToJson() {
		String catName = getIntent().getStringExtra("category");
		System.out.println("catName : " + catName);
		if(catName.equals("wecraft_category1")) {
			URL = BATIK_ENDPOINT;
			RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(URL).setLogLevel(retrofit.RestAdapter.LogLevel.FULL).build();
			api = restAdapter.create(Api.class);
			
			api.getBatikData(new Callback<List<Company>>() {
				
				@Override
				public void success(List<Company> companies, Response response) {
					// TODO Auto-generated method stub
					companyList = companies;
					adapter = new CompanyAdapter(getApplicationContext(), R.layout.company_list, companyList, URL);
					setListAdapter(adapter);
				}
				
				@Override
				public void failure(RetrofitError arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
					System.out.println(arg0.toString());
				}
			});
		} else if(catName.equals("wecraft_category2")) {
			URL = FURNITUR_ENDPOINT;
			RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(URL).setLogLevel(retrofit.RestAdapter.LogLevel.FULL).build();
			api = restAdapter.create(Api.class);
			
			api.getFurniturData(new Callback<List<Company>>() {
				
				@Override
				public void success(List<Company> companies, Response response) {
					// TODO Auto-generated method stub
					companyList = companies;
					adapter = new CompanyAdapter(getApplicationContext(), R.layout.company_list, companyList, URL);
					setListAdapter(adapter);
				}
				
				@Override
				public void failure(RetrofitError arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
					System.out.println(arg0.toString());
				}
			});
		} else if(catName.equals("wecraft_category3")) {
			URL = HIASAN_DAN_DEKORASI_ENDPOINT;
			RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(URL).setLogLevel(retrofit.RestAdapter.LogLevel.FULL).build();
			api = restAdapter.create(Api.class);
			
			api.getHiasDanDekorData(new Callback<List<Company>>() {
				
				@Override
				public void success(List<Company> companies, Response response) {
					// TODO Auto-generated method stub
					companyList = companies;
					adapter = new CompanyAdapter(getApplicationContext(), R.layout.company_list, companyList, URL);
					setListAdapter(adapter);
				}
				
				@Override
				public void failure(RetrofitError arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
					System.out.println(arg0.toString());
				}
			});
		} else if(catName.equals("wecraft_category4")) {
			URL = PERHIASAN_DAN_AKSESORIS_ENDPOINT;
			RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(URL).setLogLevel(retrofit.RestAdapter.LogLevel.FULL).build();
			api = restAdapter.create(Api.class);
			
			api.getPerhiasanDanAksesorisData(new Callback<List<Company>>() {
				
				@Override
				public void success(List<Company> companies, Response response) {
					// TODO Auto-generated method stub
					companyList = companies;
					adapter = new CompanyAdapter(getApplicationContext(), R.layout.company_list, companyList, URL);
					setListAdapter(adapter);
				}
				
				@Override
				public void failure(RetrofitError arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
					System.out.println(arg0.toString());
				}
			});
		}	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, ProfileActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		intent.putExtra("company", adapter.getCompany(position));
		intent.putExtra("URL", URL);
		startActivity(intent);
    }
}





