package id.wecraft.network;

import id.wecraft.model.Company;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface Api {

	@GET("/TrueBatikArray.json")
    public void getBatikData(Callback<List<Company>> response);
	
	@GET("/furnitur.json")
    public void getFurniturData(Callback<List<Company>> response);
	
	@GET("/hiasdandekor.json")
    public void getHiasDanDekorData(Callback<List<Company>> response);
	
	@GET("/perhiasandanaksesoris.json")
    public void getPerhiasanDanAksesorisData(Callback<List<Company>> response);
}
