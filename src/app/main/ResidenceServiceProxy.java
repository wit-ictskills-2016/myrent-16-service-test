package app.main;

import java.util.List;

import app.models.Residence;
import app.models.Landlord;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface ResidenceServiceProxy
{

  @GET("/api/landlords")
  Call<List<Landlord>> getAllLandlords();

  @GET("/api/landlords/{id}")
  Call<Landlord> getLandlord(@Path("id") String id);

  @POST("/api/landlords")
  Call<Landlord> createLandlord(@Body Landlord residenceer);

  @DELETE("/api/landlords/{id}")
  Call<Landlord> deleteLandlord(@Path("id") String id);

  @DELETE("/api/landlords")
  Call<String> deleteAllLandlords();

  @GET("/api/residences")
  Call<List<Residence>> getAllResidences();

  @DELETE("/api/residences")
  Call<String> deleteAllResidences();

  @GET("/api/landlords/{id}/residences")
  Call<List<Residence>> getResidences(@Path("id") String id);
  
  @GET("/api/landlords/{id}/residences/{residenceId}")
  Call<Residence> getResidence(@Path("id") String id, @Path("residenceId") String residenceId);

  @POST("/api/landlords/{id}/residences")
  Call<Residence> createResidence(@Path("id") String id, @Body Residence residence);

  @DELETE("/api/landlords/{id}/residences/{residenceId}")
  Call<String> deleteResidence(@Path("id") String id, @Path("residenceId") String residenceId);
}
