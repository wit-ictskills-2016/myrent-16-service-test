package app.main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.models.Residence;
import app.models.Landlord;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ResidenceServiceAPI
{
  private String service_url = "http://localhost:9000";
  private ResidenceServiceProxy service;

  public ResidenceServiceAPI()
  {
    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(service_url)
                             .addConverterFactory(GsonConverterFactory
                             .create(gson))
                             .build();
    service = retrofit.create(ResidenceServiceProxy.class);
  }

  public List<Landlord> getAllLandlords() throws Exception
  {
    Call<List<Landlord>> call = (Call<List<Landlord>>) service.getAllLandlords();
    Response<List<Landlord>> landlords = call.execute();
    return landlords.body();
  }

  public Landlord getLandlord(String id) throws Exception
  {
    Call<Landlord> call = (Call<Landlord>) service.getLandlord(id);
    Response<Landlord> landlords = call.execute();
    return landlords.body();
  }

  public int deleteLandlord(String id) throws Exception
  {
    Call<Landlord> call = service.deleteLandlord(id);
    Response<Landlord> val = call.execute();
    return val.code();
  }

  public int deleteAllLandlords() throws Exception
  {
    Call<String> call = service.deleteAllLandlords();
    Response<String> val = call.execute();
    return val.code();
  }
//================================================================
  public Landlord createLandlord(Landlord newLandlord) throws Exception
  {
    Call<Landlord> call = (Call<Landlord>) service.createLandlord(newLandlord);
    Response<Landlord> returnedLandlord = call.execute();
    return returnedLandlord.body();
  }

  public List<Residence> getAllResidences() throws Exception
  {
    Call<List<Residence>> call = (Call<List<Residence>>) service.getAllResidences();
    Response<List<Residence>> residences = call.execute();
    return residences.body();
  }

  public Residence getResidence(String landlordId, String residenceId) throws Exception
  {
    Call<Residence> call = (Call<Residence>) service.getResidence(landlordId, residenceId);
    Response<Residence> residence = call.execute();
    return residence.body(); 
    
  }
  public List<Residence> getResidences(String id) throws Exception
  {
    Call<List<Residence>> call = (Call<List<Residence>>) service.getResidences(id);
    Response<List<Residence>> residences = call.execute();
    return residences.body();
  }
  
  public Residence createResidence(String id, Residence newResidence) throws Exception
  {
    Call<Residence> call = (Call<Residence>) service.createResidence(id, newResidence);
    Response<Residence> returnedResidence = call.execute();
    return returnedResidence.body();
  }

  public int deleteResidence(String id, String residenceId) throws Exception
  {
    Call<String> call = service.deleteResidence(id, residenceId);
    Response<String> val = call.execute();
    return val.code();
  }

  public int deleteAllResidences() throws Exception
  {
    Call<String> call = service.deleteAllResidences();
    Response<String> val = call.execute();
    return val.code();
  }
}