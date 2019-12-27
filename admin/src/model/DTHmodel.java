package model;

import java.io.InputStream;

public class DTHmodel {
	private String connection_Name;
	private int CID;
	
	private String  special_content;
	private int prize;
	private String SetBoxName;
	private String features;
	private InputStream photo;
	private int boxid;
	
	public int getBoxid() {
		return boxid;
	}
	public void setBoxid(int boxid) {
		this.boxid = boxid;
	}
	public String getSpecial_content() {
		return special_content;
	}
	public void setSpecial_content(String special_content) {
		this.special_content = special_content;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public String getSetBoxName() {
		return SetBoxName;
	}
	public void setSetBoxName(String setBoxName) {
		SetBoxName = setBoxName;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public String getConnection_Name() {
		return connection_Name;
	}
	public void setConnection_Name(String connection_Name) {
		this.connection_Name = connection_Name;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	

}
