package com.rahmed.redhat.demo.rest;

import java.util.HashMap;
import java.util.Map;

public class ProcessorBean {
	public Map<String, Object> processJMSMessage(SubmissionDocument document) {

		Map<String, Object> map = new HashMap<String, Object>();

		//Object body = (Object) exchange.getIn().getBody();

		// map.put("ERROR_ID",111);
		// map.put("ERROR_CODE",headers.get("ERROR-CODE"));
		// map.put("ERROR_MESSAGE",headers.get("ERROR-MESSAGE"));
		// map.put("MESSAGE", body.toString());
		// map.put("STATUS", "ERROR");
		map.put("ID", document.getId());
		map.put("MESSAGE_ATTRIBUTE_1", document.getMessageAttribute1());
		map.put("MESSAGE_ATTRIBUTE_2", document.getMessageAttribute2());
		return map;
	}
}
