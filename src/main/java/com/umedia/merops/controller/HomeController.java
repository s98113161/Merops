package com.umedia.merops.controller;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.UnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umedia.merops.DragonflyException;
import com.umedia.merops.IDragonflyService;
//import com.umedia.merops.SparklrService;
import com.umedia.merops.impl.DragonflyServiceConsumer;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired	
	private IDragonflyService dragonflyService;
	
	@RequestMapping("/")
	public String home()
	{
		return "tonr";
	}
	
	@RequestMapping("/tonr")
	public String tonr() throws DragonflyException
	{
		//dragonflyService.getDevices();
		return "tonr";
	}
	
	@RequestMapping("/merops/photos")
	public String mphotos(Model model) throws Exception {
		//model.addAttribute("photoIds", dragonflyService.getDevices());
		model.addAttribute("photoIds", dragonflyService.getSparklrPhotos());
		return "sparklr";
	}
	
	@RequestMapping("/devices")
	public String getDeviceListFromDragonflyJson(Model model) throws Exception {
		String deviceIds = dragonflyService.getDragonflyDevice();
		//model.addAttribute("photoIds", dragonflyService.getDevices());
		
		model.addAttribute("d", deviceIds);
		
		return "sparklr";
	}
}
