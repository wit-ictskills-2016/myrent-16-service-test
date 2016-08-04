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
 * Complete list api methods tested
POST    /api/residence               ResidencesAPI.createResidence
GET     /api/residences              ResidencesAPI.getAllResidences
DELETE  /api/residences/{id}         ResidencesAPI.deleteResidence
POST    /api/residence/update        ResidencesAPI.updateResidence
 */

public class ResidenceTest {
	private static ResidenceServiceAPI service = new ResidenceServiceAPI();

	private int NUMBER_residences = 8;

	static Residence residences[] = { new Residence(), new Residence(), new Residence(), new Residence(),
			new Residence(), new Residence(), new Residence(), new Residence(),

	};

    /**
     * Create an array of residences.
     * @throws Exception
     */
	@Before
	public void setup() throws Exception {
		service.createResidence(residences[0]);
		service.createResidence(residences[1]);
		service.createResidence(residences[2]);
		service.createResidence(residences[3]);
		service.createResidence(residences[4]);
		service.createResidence(residences[5]);
		service.createResidence(residences[6]);
		service.createResidence(residences[7]);
	}

    /**
     * Clean up following tests.
     * @throws Exception
     */
	@After
	public void teardown() throws Exception {
		for (int i = 0; i < residences.length; i += 1) {
		  service.deleteResidence(residences[i].uuid);
		}
	}

	/**
	 * Obtain entire collection of residences
	 * @throws Exception
	 */
	@Test
	public void getResidences() throws Exception {
		List<Residence> residences = service.getResidences();
		assertEquals(residences.size(), NUMBER_residences);
	}

    /**
     * Delete a single residence
     * @throws Exception
     */
	@Test
	public void deleteResidence() throws Exception {
		String residenceId = residences[0].uuid;
		int rval = service.deleteResidence(residenceId);
		assertEquals(rval, 200);
	}
	
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
