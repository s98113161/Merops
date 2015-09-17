package com.umedia.merops.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.umedia.merops.DragonflyException;
import com.umedia.merops.IDragonflyService;
//import com.umedia.merops.SparklrException;

public class DragonflyServiceConsumer implements IDragonflyService {

	private String dragonflyDeviceListURL;
	private String sparklrPhotoListURL;
	private RestOperations dragonflyRestTemplate;

	private RestOperations trustedClientRestTemplate;
	private String sparklrTrustedMessageURL;

	@Override
	public List<String> getSparklrPhotos() throws DragonflyException {
		// TODO Auto-generated method stub
		try {
			InputStream photosXML = new ByteArrayInputStream(
					dragonflyRestTemplate.getForObject(
							URI.create(sparklrPhotoListURL), byte[].class));

			final List<String> photoIds = new ArrayList<String>();
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setValidating(false);
			parserFactory.setXIncludeAware(false);
			parserFactory.setNamespaceAware(false);
			SAXParser parser = parserFactory.newSAXParser();
			parser.parse(photosXML, new DefaultHandler() {
				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if ("photo".equals(qName)) {
						photoIds.add(attributes.getValue("id"));
					}
				}
			});
			return photoIds;
		}catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
		/*} catch (IOException e) {
			throw new IllegalStateException(e);
		} catch (SAXException e) {
			throw new IllegalStateException(e);
		} catch (ParserConfigurationException e) {
			throw new IllegalStateException(e);
		}*/
	}

	public String getDragonflyDeviceListURL() {
		return dragonflyDeviceListURL;
	}

	public void setDragonflyDeviceListURL(String dragonflyDeviceListURL) {
		this.dragonflyDeviceListURL = dragonflyDeviceListURL;
	}

	public RestOperations getDragonflyRestTemplate() {
		return dragonflyRestTemplate;
	}

	public void setDragonflyRestTemplate(RestOperations dragonflyRestTemplate) {
		this.dragonflyRestTemplate = dragonflyRestTemplate;
	}

	@Override
	public String getDragonflyDevice() throws DragonflyException {
		// TODO Auto-generated method stub
		try {
			/*InputStream photosJson = new ByteArrayInputStream(
					dragonflyRestTemplate.getForObject(
							URI.create(dragonflyDeviceListURL), byte[].class));*/
			String photosJson = 
					dragonflyRestTemplate.getForObject(
							URI.create(dragonflyDeviceListURL), String.class);

			String result = photosJson.toString();
			/*final List<String> photoIds = new ArrayList<String>();
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			parserFactory.setValidating(false);
			parserFactory.setXIncludeAware(false);
			parserFactory.setNamespaceAware(false);
			SAXParser parser = parserFactory.newSAXParser();
			parser.parse(photosXML, new DefaultHandler() {
				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if ("photo".equals(qName)) {
						photoIds.add(attributes.getValue("id"));
					}
				}
			});*/
			return result;
		}catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
		//return null;
	}

	public String getSparklrPhotoListURL() {
		return sparklrPhotoListURL;
	}

	public void setSparklrPhotoListURL(String sparklrPhotoListURL) {
		this.sparklrPhotoListURL = sparklrPhotoListURL;
	}	

}
