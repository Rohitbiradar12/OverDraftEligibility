package com.tigo.tcs.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWebServiceConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet,"/ws/*");
	}
	@Bean(name="TcsValidation")
	public DefaultWsdl11Definition defaultWsdl11Defination(XsdSchema schema) {
		DefaultWsdl11Definition defination = new DefaultWsdl11Definition();
	    defination.setPortTypeName("TcsValidationPort");
	    defination.setLocationUri("/ws");
	    defination.setTargetNamespace("http://www.tigo.com/TCS");
	    defination.setSchema(schema);
	    return defination;
	}
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/schema/TCSService.xsd"));
	}
}
