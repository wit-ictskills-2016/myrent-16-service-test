package app.main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.models.Residence;
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

  public List<Residence> getResidences() throws Exception
  {
    Call<List<Residence>> call = (Call<List<Residence>>) service.getResidences();
    Response<List<Residence>> residences = call.execute();
    return residences.body();
  }
 
  public Residence createResidence(Residence newResidence) throws Exception
  {
	    Call<Residence> call = (Call<Residence>) service.createResidence(newResidence);
	    Response<Residence> returnedResidence = call.execute();
	    return returnedResidence.body();
  }
  
  public int deleteResidence(Long id) throws Exception
  {
    Call<String> call = service.deleteResidence(id);
    Response<String> val = call.execute();
    return val.code();
  }

  public Residence updateResidence(Residence residence) throws Exception {
	  Call<Residence> call = (Call<Residence>)service.updateResidence(residence);
	  Response<Residence> returnedResidence = call.execute();
	  return returnedResidence.body();
  }
}