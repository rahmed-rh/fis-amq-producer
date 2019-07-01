package com.rahmed.redhat.demo.rest;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "topic")
public class SubmissionREST extends RouteBuilder {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public void configure() {

		/*
		 * errorHandler(deadLetterChannel) .maximumRedeliveries(3) .backOffMultiplier(4)
		 * .retryAttemptedLogLevel(LoggingLevel.WARN)
		 * .onRedelivery(Utils.customRedeliverProcessor()) // setting delay to zero is
		 * just to make testing faster .redeliveryDelay(0L));
		 */
	
		
		rest("/submission").description("IVO Submission Service")

				.post("/").type(SubmissionDocument.class).description("Create a new Document Submission for IVO, We are trying to vlaidate the message loss possibilities").route().routeId("process-submission")
				.tracing().log("targetQueue is ${body.targetQueue}").setHeader("targetQueue", ExpressionBuilder.append(constant("direct:"), simple("${body.targetQueue}")))
				.log("targetQueue is ${header.targetQueue}")
					//I need to create a JMS
			 		.bean(ProcessorBean.class, "processJMSMessage(${body})")
			 		.setExchangePattern(ExchangePattern.InOnly)
			 		.to("activemq:topic:"+getName())
			 		.recipientList(header("targetQueue"))
			 		.transform(constant("OK Message Sent"))
		         .end()
			.endRest();
		
		
         
        from("direct:demoQueue")
        .log("Calling demoQueue -->  '${body}'");
         
        from("direct:demoQueue1")
        .log("Calling demoQueue1 -->  '${body}'");
         
        from("direct:demoQueue2")
        .log("Calling demoQueue2 -->  '${body}'");

	}
}
