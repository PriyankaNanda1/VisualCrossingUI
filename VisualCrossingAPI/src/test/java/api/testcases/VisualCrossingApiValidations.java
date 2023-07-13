package api.testcases;

import org.asynchttpclient.util.Assertions;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.VisualCrossingApiEndpoint;
import api.pojo.DaysPojo;
import api.pojo.HoursPojo;
import api.pojo.VisualCrossingPojo;

public class VisualCrossingApiValidations {
	
	//Test for Response Body of Valid CityName
	
	@Test(priority = 1)

	public void validateApi() {
		// Get the JSON response from the API.
		VisualCrossingPojo pojo = VisualCrossingApiEndpoint.getApi();

		// Assert that the response is not null.
		Assert.assertNotNull(pojo);

		// Assert that the response contains the expected latitude.
		System.out.println("Latitude:" + pojo.getLatitude());
		assertThat(pojo.getLatitude(), equalTo(16.2033));
		

		// Assert that the response contains the expected latitude.
		System.out.println("Longitude:" + pojo.getLongitude());
		assertThat(pojo.getLongitude(), equalTo(77.3449));

		// Assert that the response contains the expected resolved address.
		System.out.println("ResolvedAddress:" + pojo.getResolvedAddress());
		assertThat(pojo.getResolvedAddress(), equalTo("Raichur, Karnataka, India"));

		// Assert that the response contains the expected address.
		System.out.println("Address:" + pojo.getAddress());
		assertThat(pojo.getAddress(), equalTo("Raichur"));

		// Assert that the response contains the expected timezone.
		System.out.println("Timezone:" + pojo.getTimezone());
		assertThat(pojo.getTimezone(), equalTo("Asia/Kolkata"));
		
		//Prints all the 15 Days details
		List<DaysPojo> list= pojo.getDays();
		for(int i=0;i<list.size();i++)
		{   
			DaysPojo day = list.get(i);
			System.out.println(day);
//-----------------------< Hourly Details >------------------------------------
		    List<HoursPojo> hours = day.getHours();

		    for (int j = 0; j < hours.size(); j++) {
		        HoursPojo hour = hours.get(j);
//
//		        System.out.println(hour);
		    }
		}
		
		
		

	}
}
