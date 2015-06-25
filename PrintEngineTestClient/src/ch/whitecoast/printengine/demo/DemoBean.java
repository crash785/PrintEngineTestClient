package ch.whitecoast.printengine.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.catalina.core.ApplicationPart;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ch.whitecoast.printengine.objects.PrintRequestObj;
import ch.whitecoast.printengine.objects.PrintResponseObj;
import ch.whitecoast.printengine.objects.Value;
import ch.whitecoast.printengine.objects.ValueMap;
import ch.whitecoast.printengine.service.PrintServiceProxy;
import ch.whitecoast.printengine.service.PrintServiceServiceLocator;

/**
 * @author tkaler
 * @since 15.06.2015
 */
@ManagedBean(name="demoBean")
@ViewScoped
public class DemoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<ArrayList<Value>> data;
	
	private ApplicationPart file;
	private String fileType;
	private String responseType;
	private String newBookmarkName;
	private int newBookmarkNameIndex;
	private StreamedContent downloadFile;

	@PostConstruct
	public void init(){
		data = new ArrayList<ArrayList<Value>>();
	}
	
	public void start(){
		PrintRequestObj request = new PrintRequestObj();

		try {
			request.setFileData(getBytes(file.getInputStream()));

			request.setFileType(this.fileType);
			request.setResponseType(this.responseType);
			
			ValueMap[] valueMaps = new ValueMap[data.size()];
			for(int x = 0; x < data.size(); x++){
				valueMaps[x] = new ValueMap();
				Value[] valueArray = new Value[data.get(x).size()];
				for(int y = 0; y < data.get(x).size(); y++){
					valueArray[y] = data.get(x).get(y);
					valueArray[y].setKey(data.get(x).get(y).getKey().toString()); 
				}
				valueMaps[x].setValueMap(valueArray);
			}
			
			request.setValueMaps(valueMaps);
			
			PrintServiceServiceLocator locator = new PrintServiceServiceLocator();		
			PrintServiceProxy proxy = new PrintServiceProxy(locator.getPrintServiceAddress());
		
			PrintResponseObj response = proxy.getDocument(request);
			InputStream responseStream = new ByteArrayInputStream(response.getFileData());
			if(response.getFileType().equals(".pdf")){
				this.downloadFile = new DefaultStreamedContent(responseStream, "application/pdf", file.getFilename().substring(0, file.getFilename().lastIndexOf(".")) + "_PrintDemo" + response.getFileType());
			}
			else{
				this.downloadFile = new DefaultStreamedContent(responseStream, "application/msword", file.getFilename().substring(0, file.getFilename().lastIndexOf(".")) + "_PrintDemo" + response.getFileType());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void addDataRow(){
		ArrayList<Value> tmpMap = new ArrayList<Value>();
		
		data.add(tmpMap);
	}
	
	public void addBookmark(){
		Value tmpValue = new Value();
		tmpValue.setKey(this.newBookmarkName);
		data.get(this.newBookmarkNameIndex).add(tmpValue);
		this.newBookmarkName = "";
	}
	
	public void addValue(int dataRow, int bookmarkIterator){
		
		String[] oldValues = data.get(dataRow).get(bookmarkIterator).getValues();
		
		if(oldValues == null)
			oldValues = new String[0];
		
		String[] newValues = new String[oldValues.length + 1];
		
		int x;
		
		for(x = 0; x < oldValues.length; x++){
			newValues[x] = oldValues[x];
		}
		
		newValues[x++] = "";
		
		data.get(dataRow).get(bookmarkIterator).setValues(newValues);
	}
	
	public void deleteBookmark(int dataRow, String bookmarkName){
		data.get(dataRow).remove(bookmarkName);
	}
	
	public void deleteValue(int dataRow, int bookmarkIterator, int valueId){
		String[] oldValues = data.get(dataRow).get(bookmarkIterator).getValues();
		
		if(oldValues == null)
			return;
		
		String[] newValues = new String[oldValues.length - 1];
		
		if(newValues.length > 0){
			int x = 0;
			int y = 0;
			while(y < oldValues.length){
				if(y != valueId){
					newValues[x] = oldValues[y];
					x++;
				}
				y++;
			}
		}
		
		data.get(dataRow).get(bookmarkIterator).setValues(newValues);
	}
	
	public void deleteDataRow(int dataRow){
		data.remove(dataRow);
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - HELPER - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	private static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}
	
	public int getLengthOfValues(int dataRow, int bookmarkIterator){
		if(data.get(dataRow).get(bookmarkIterator).getValues() == null)
			return 0;
		return data.get(dataRow).get(bookmarkIterator).getValues().length;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - GETTER & SETTER - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the file
	 */
	public ApplicationPart getFile() {
		return file;
	}
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param file the file to set
	 */
	public void setFile(ApplicationPart file) {
		this.file = file;
	}
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the responseType
	 */
	public String getResponseType() {
		return responseType;
	}
	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param responseType the responseType to set
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the data
	 */
	public ArrayList<ArrayList<Value>> getData() {
		return data;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param data the data to set
	 */
	public void setData(ArrayList<ArrayList<Value>> data) {
		this.data = data;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the newBookmarkName
	 */
	public String getNewBookmarkName() {
		return newBookmarkName;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param newBookmarkName the newBookmarkName to set
	 */
	public void setNewBookmarkName(String newBookmarkName) {
		this.newBookmarkName = newBookmarkName;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @return the newBookmarkNameIndex
	 */
	public int getNewBookmarkNameIndex() {
		return newBookmarkNameIndex;
	}

	/**
	 * @TimKaler
	 * @since 15.06.2015
	 * @param newBookmarkNameIndex the newBookmarkNameIndex to set
	 */
	public void setNewBookmarkNameIndex(int newBookmarkNameIndex) {
		this.newBookmarkNameIndex = newBookmarkNameIndex;
	}

	/**
	 * @TimKaler
	 * @since 17.06.2015
	 * @return the downloadFile
	 */
	public StreamedContent getDownloadFile() {
		return downloadFile;
	}

	/**
	 * @TimKaler
	 * @since 17.06.2015
	 * @param downloadFile the downloadFile to set
	 */
	public void setDownloadFile(StreamedContent downloadFile) {
		this.downloadFile = downloadFile;
	}
	
	
	
}
