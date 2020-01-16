package com.ahex.match.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import java.util.Map;
//import java.util.List;


//@Entity
//@Table(name="match_info")
public class MetaEntity implements Serializable{/*

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="match_info_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int match_info_Id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_meta_info_Id", referencedColumnName = "id")
	private MetEntity meta;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_info_Id", referencedColumnName = "id")
	private InfEntity info;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "match_innings_Id")
	private List<InningEntity> innings;

	public InfEntity getInfo() {
		return info;
	}

	public void setInfo(InfEntity info) {
		this.info = info;
	}

	public List<InningEntity> getInnings() {
		return innings;
	}

	public void setInnings(List<InningEntity> innings) {
		this.innings = innings;
	}

	public int getMatch_info_Id() {
		return match_info_Id;
	}

	public void setMatch_info_Id(int match_info_Id) {
		this.match_info_Id = match_info_Id;
	}

	
*/}
