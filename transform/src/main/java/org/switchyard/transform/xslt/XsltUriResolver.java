package org.switchyard.transform.xslt;

import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

public class XsltUriResolver implements URIResolver {

	@Override
	public Source resolve(String href, String base) throws TransformerException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(href);
        return new StreamSource(inputStream);
	}
}
