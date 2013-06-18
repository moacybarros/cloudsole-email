package org.thys.michels.email2sfdc.sfdc;

import javax.mail.Message;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.force.api.ApiConfig;
import com.force.api.ForceApi;
import org.json.simple.JSONObject;

public class Email2sfdc {
	public ForceApi SoapLogin() {
		ForceApi api = new ForceApi(new ApiConfig()
			.setUsername("username")
			.setPassword("password"));
		return api;
	}
	
	public void createCaseFromEmail(Message newEmail)
	{
		/*JSONObject json = new JSONObject();
		json.putAll(newEmail.getSubject());
	 
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		Object newsobject = (Object) mapper.readValue(json.toJSONString(), Object.class);
		String id = SoapLogin().createSObject("Case", newsobject);
		*/
	}
}
