package com.rahmed.redhat.demo.rest;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class Utils {
	public static Processor customRedeliverProcessor() {
		return new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
		        // the message is being redelivered so we can alter it

		        // we just append the redelivery counter to the body
		        // you can of course do all kind of stuff instead
				Map body = exchange.getIn().getBody(Map.class);
		        int count = exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER, Integer.class);

		        body.put("MESSAGE_ATTRIBUTE_1", "Corrected");
		        
		        exchange.getIn().setBody(body);
		        

		       
				
		    }

		};
	}
}
