package app.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.main.ResidenceServiceAPI;
import app.models.Residence;
import app.models.Landlord;


/**
Complete list api methods tested
# Landlord (the user)
GET     /api/landlords                              LandlordsAPI.getAllLandlords     
GET     /api/landlords/{id}                         LandlordsAPI.getLandlord         
POST    /api/landlords                              LandlordsAPI.createLandlord      
DELETE  /api/landlords/{id}                         LandlordsAPI.deleteLandlord      
DELETE  /api/landlords                              LandlordsAPI.deleteAllLandlords  

# Residence
GET     /api/residences                                ResidencesAPI.getAllResidences         
DELETE  /api/residences                                ResidencesAPI.deleteAllResidences      
GET     /api/landlords/{id}/residences                  ResidencesAPI.getResidences            
GET     /api/landlords/{id}/residences/{residenceId}        ResidencesAPI.getResidence             
POST    /api/landlords/{id}/residences                  ResidencesAPI.createResidence          
DELETE  /api/landlords/{id}/residences/{residenceId}        ResidencesAPI.deleteResidence          
*/

public class ResidenceTest
{
  private static ResidenceServiceAPI service = new ResidenceServiceAPI();
  
  private int NUMBER_landlords   = 4;
  private int NUMBER_residences = 8;
  
  static Landlord landlords[] =
  {
    new Landlord("Homer", "Simpson"),
    new Landlord("Marge", "Simpson"),
    new Landlord("Bart", "Simpson"),
    new Landlord("Lisa", "Simpson")

  };
  
  static Residence residences[] = 
  {
    new Residence(),
    new Residence(),
    new Residence(),
    new Residence(),
    new Residence(),
    new Residence(),
    new Residence(),
    new Residence(),

  };
  
  /**
   * POST /api/landlords LandlordsAPI.createLandlord POST /api/residences
   * LandlordsAPI.createResidence
   */
  @Before
  public void setup() throws Exception
  {
    for (Landlord landlord : landlords)
    {
      service.createLandlord(landlord);
    }

    service.createResidence(landlords[0].id, residences[0]);
    service.createResidence(landlords[0].id, residences[1]);

    service.createResidence(landlords[1].id, residences[2]);
    service.createResidence(landlords[1].id, residences[3]);

    service.createResidence(landlords[2].id, residences[4]);
    service.createResidence(landlords[2].id, residences[5]);

    service.createResidence(landlords[3].id, residences[6]);
    service.createResidence(landlords[3].id, residences[7]);
  }

  /**
   * DELETE /api/residences ResidencesAPI.deleteAllResidences DELETE /api/landlords
   * ResidencesAPI.deleteAllLandlordss
   */
  @After
  public void teardown() throws Exception
  {
    service.deleteAllLandlords();
    service.deleteAllResidences();
  }

  /**
   * GET /api/landlords LandlordsAPI.getAllLandlords
   */
  @Test
  public void getAllLandlords() throws Exception
  {
    List<Landlord> landlords = service.getAllLandlords();
    assertEquals(landlords.size(), NUMBER_landlords);
  }

  /**
   * GET /api/residences ResidencesAPI.getAllResidences
   */
  @Test
  public void getAllResidences() throws Exception
  {
    List<Residence> residences = service.getAllResidences();
    assertEquals(residences.size(), NUMBER_residences);
  }

  /**
   * DELETE /api/landlords/{id} LandlordsAPI.deleteLandlord
   */
  @Test
  public void deleteResidence() throws Exception
  {
    String residenceId = residences[0].id;
    String landlordId = landlords[0].id;
    int rval = service.deleteResidence(landlordId, residenceId);
    assertEquals(rval, 200);
  }

  /**
   * DELETE /api/landlords/{id} LandlordsAPI.deleteLandlord
   */
  @Test
  public void deleteLandlord() throws Exception
  {
    int rval = service.deleteLandlord(landlords[0].id);
    assertEquals(rval, 200);
  }

  /**
   * GET /api/landlords/{id} LandlordsAPI.getLandlord
   */
  @Test
  public void getLandlord() throws Exception
  {
    Landlord landlord = service.getLandlord(landlords[3].id);
    assertEquals(landlord, landlords[3]);
  }

  /**
   * GET /api/landlords/{id}/residences ResidencesAPI.getResidences
   */
  @Test
  public void getResidences() throws Exception
  {
    String landlordId = landlords[1].id;
    List<Residence> residences = service.getResidences(landlordId);
    assertEquals(residences.size(), 2);
  }

  /**
   * GET /api/landlords/{id}/residences/{residenceId} ResidencesAPI.getResidence
   */
  @Test
  public void getResidence() throws Exception
  {
    String landlordId = landlords[2].id;
    String residenceId = residences[5].id;
    Residence residence = service.getResidence(landlordId, residenceId);
    assertEquals(residences[5], residence);
  }

}
