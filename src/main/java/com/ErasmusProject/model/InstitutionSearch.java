package com.ErasmusProject.model;

/**
 * 
 * @author Nina
 *
 */
public class InstitutionSearch {

	private String id;
	private String name;
	private String status;
	private String type;
	private String location;
	
	public InstitutionSearch(String id, String name, String status, String type, String location) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.type = type;
		this.location = location;
	}
	public InstitutionSearch() {
		this.id = "";
		this.name = "";
		this.status = "";
		this.type = "";
		this.location = "";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "InstitutionSearch [id=" + id + ", name=" + name + ", status=" + status + ", type=" + type
				+ ", location=" + location + "]";
	}
	
}
