package com.umedia.merops;

import java.util.List;

public interface IDragonflyService {

	List<String> getSparklrPhotos() throws DragonflyException;
	String getDragonflyDevice() throws DragonflyException;
	//List<String> getSparklrPhotoIds() throws DragonflyException;
	//String readDeviceStatus(String deviceId) throws DragonflyException;
	//String getTrustedMessage();
}
