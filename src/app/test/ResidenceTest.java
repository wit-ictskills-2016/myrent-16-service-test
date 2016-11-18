package app.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.main.ResidenceServiceAPI;
import app.models.Residence;
/**
 * Complete list api methods tested
POST    /api/residence               ResidencesAPI.createResidence
GET     /api/residences              ResidencesAPI.getResidences
GET     /api/residences/{id}         ResidencesAPI.getResidence
DELETE  /api/residences/{id}         ResidencesAPI.deleteResidence
POST    /api/residence/update        ResidencesAPI.updateResidence
 */

public class ResidenceTest {
	private static ResidenceServiceAPI service = new ResidenceServiceAPI();

	private int NUMBER_RESIDENCES = 8;

	static Residence residences[] = { 
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
     * Set up for test.
     * Create an array of residences on server.
     * Server echos back each individual residence as it is created.
     * The server model generates the residence id.
     * Obtain this from the reflected back residence and apply 
     * to ResidenceTest.residences fields.
     * 
     * @throws Exception
     */
	@Before
	public void setup() throws Exception {

		for (int i = 0; i < NUMBER_RESIDENCES; i += 1) {
			Residence res = service.createResidence(residences[i]);
			residences[i].id = res.id;
		}
	}

    /**
     * Clean up following tests.
     * @throws Exception
     */
	@After
	public void teardown() throws Exception {
		for (int i = 0; i < residences.length; i += 1) {
		  service.deleteResidence(residences[i].id);
		}
	}

	/**
	 * Obtain entire collection of residences
	 * @throws Exception
	 */
	@Test
	public void getResidences() throws Exception {
		List<Residence> list = service.getResidences();
		assertEquals(list.size(), NUMBER_RESIDENCES);
	}

	 /**
   * Check the getResidence api
   * @throws Exception
   */
  @Test
  public void getResidence() throws Exception {
    Residence residence = service.getResidence(residences[0].id);
    assertEquals(residence.id, residences[0].id);
  }
  
    /**
     * Delete a single residence
     * @throws Exception
     */
	@Test
	public void deleteResidence() throws Exception {
		Long residenceId = residences[0].id;
		int rval = service.deleteResidence(residenceId);
		assertEquals(rval, 200);
	}
	
	/**
	 * Update a residence on the server.
	 * @throws Exception
	 */
	@Test
	public void updateResidence() throws Exception {
		Residence res = residences[3];
		// Make some changes
		res.photo = "Homer's portrait";
		res.rented = true;
		res.tenant = "Homer Simpson";
		Residence returnedRes = service.updateResidence(res);
		assertEquals(returnedRes, res);
	}

}
