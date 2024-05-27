package restful.booker;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.github.javafaker.Faker;

public class GenerateData {
	Faker faker =  new Faker();
	
	
	
	public Map<String, Object> generateBookingData() {
		Map<String, Object> data = new HashMap<>();
		data.put("firstname", faker.name().firstName());
		data.put("lastname", faker.name().lastName());
		data.put("totalprice", faker.number().numberBetween(100, 999));
		data.put("depositpaid", faker.bool().bool());
		data.put("bookingdates", generateDateFormat());
		data.put("additionalneeds", faker.options().option("breakfast", "lunch", "snacks", "dinner"));
		return data;
	}
	
	public Map<String, Object> generateDateFormat() {
		Map<String, Object> data = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		data.put("checkin", dateFormat.format(faker.date().past(1000, TimeUnit.DAYS)));
		data.put("checkout", dateFormat.format(faker.date().future(1000, TimeUnit.DAYS)));
		return data;
	}

}
