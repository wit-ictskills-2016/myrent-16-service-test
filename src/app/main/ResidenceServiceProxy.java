package app.main;

import java.util.List;

import app.models.Residence;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface ResidenceServiceProxy
{

  
  // Residence
  @POST("/api/residence")
  Call<Residence> createResidence(@Body Residence residence);
  
  @DELETE("/api/residences/{uuid}")
  Call<String> deleteResidence(@Path("uuid") String uuid);
  
  @POST("/api/residence/update")
  Call<Residence> updateResidence(@Body Residence residence);
  
  @GET("/api/residences")
  Call<List<Residence>> getResidences();
  
}
