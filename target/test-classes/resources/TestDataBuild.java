package resources;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import pojo.PlaceOrder;

public class TestDataBuild {

	public PlaceOrder placeOrderPayload(String isadult,String id,String typeid,String quantity,String name,String email,String price,
			String DateTime)
	{
		PlaceOrder po = new PlaceOrder();
		po.setIsadult(Boolean.parseBoolean(isadult));
		po.setId(Integer.parseInt(id));
		po.setTypeid(Integer.parseInt(typeid));
		po.setName(name);
		po.setQuantity(4);
		po.setEmail(email);
		po.setPrice(Double.parseDouble(price));
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        // Parse the date from a string
        String dateString = DateTime;
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString, formatter);

        // Convert OffsetDateTime to Date
        Date date = Date.from(offsetDateTime.toInstant());

        // Set the date using setDate method
        po.setDate(date);
		
		return po;
	}
	
	public String updateNamePayload(String name)
	{
		 	return "{\r\n    \"Name\":\""+name+"\"\r\n}";
	}
}


