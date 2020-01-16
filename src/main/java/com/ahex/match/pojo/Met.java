package com.ahex.match.pojo;

public class Met {

	private String data_version;
	private String created;
	private String revision;
	
	
	public String getData_version() {
		return data_version;
	}
	public void setData_version(String data_version) {
		this.data_version = data_version;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	
	@Override
    public String toString() {
        return "Met{" +
                "data_version='" + data_version + '\'' +
                ", created='" + created + '\'' +
                ", revision='" + revision + '\'' +
                '}';
    }
	
	
}
