package id.wecraft;

import java.util.ArrayList;
import java.util.List;

import id.wecraft.model.Category;
import id.wecraft.service.CategoryAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class CategoryActivity extends ListActivity {
	
	private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        List<Category> lst = getCategoryList();
        
        adapter= new CategoryAdapter(getApplicationContext(), R.layout.category_list, lst);
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category, menu);
        return true;
    }
    
    private List<Category> getCategoryList() {
		
    	List<Category> categories = new ArrayList();
		int classLength = R.drawable.class.getFields().length;
		java.lang.reflect.Field field;
		for(int i=0; i<classLength; i++) {
			field = R.drawable.class.getFields()[i];
			if(field.getName().startsWith("wecraft_category")){
				Category category = new Category();
				category.setName(field.getName());
				try {
					category.setImg(field.getInt(null));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				categories.add(category);
			}
		}
		
		return categories;
	}
}
