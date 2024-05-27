package restful.booker;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restful.booker.datamodelremove.BookingResponse;

public class APITest {
	
	ApiLibrary apiLibrary = new ApiLibrary();
	GenerateData data = new GenerateData();
	
	@Test
	public void makeABooking() {
		Map<String, Object> bookingData = data.generateBookingData();
		Response response = apiLibrary.makeAPostCall("booking", bookingData);
		response.then().statusCode(200);
		response.body().prettyPrint();
	}
	
	@Test
	public void makeABookingAndValidateWithPojo() {
		Map<String, Object> bookingData = data.generateBookingData();
		Response response = apiLibrary.makeAPostCall("booking", bookingData);
		response.then().statusCode(200);
		BookingResponse bookingResponse = response.as(BookingResponse.class);
		Assert.assertEquals(bookingResponse.getBooking().getFirstname(), bookingData.get("firstname"));
		Assert.assertEquals(bookingResponse.getBooking().getFirstname(), bookingData.get("firstname"));
		
		bookingData = data.generateBookingData();
		response = apiLibrary.makeAPostCall("booking", bookingData);
		response.then().statusCode(200);
		bookingResponse = response.as(BookingResponse.class);
		Assert.assertEquals(bookingResponse.getBooking().getTotalprice(), bookingData.get("totalprice"));
		Assert.assertEquals(bookingResponse.getBooking().getAdditionalneeds(), bookingData.get("additionalneeds"));
		
		bookingData = data.generateBookingData();
		response = apiLibrary.makeAPostCall("booking", bookingData);
		response.then().statusCode(200);
		bookingResponse = response.as(BookingResponse.class);
		Assert.assertEquals(bookingResponse.getBooking().getFirstname(), bookingData.get("firstname"));
		Assert.assertEquals(bookingResponse.getBooking().getFirstname(), bookingData.get("firstname"));

	}
	
	@Test
	public void getBookingDetails() {
		Response response = apiLibrary.makeAGetCall("booking/1");
		response.then().statusCode(200);
		response.then().contentType(ContentType.JSON);
		response.body().prettyPrint();
	}
	
	
	
	
	

}
