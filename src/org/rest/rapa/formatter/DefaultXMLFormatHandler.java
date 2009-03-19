package org.rest.rapa.formatter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.rest.rapa.resource.Resource;

public class DefaultXMLFormatHandler implements FormatHandler {

	@Override
	public Resource decode(String content, Class clazz) {
		return (Resource)JAXB.unmarshal(new StringReader(content), clazz);
	}

	@Override
	public String encode(Resource resource) {
		OutputStream outputStream = new ByteArrayOutputStream();
		JAXB.marshal(resource, outputStream);
		return outputStream.toString();
	}

	@Override
	public String getExtension() {
		return "xml";
	}

}