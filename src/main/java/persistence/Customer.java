package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer implements Serializable {

	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer id;
	private String name;
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDt;
	
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	  
	public Integer getId() {
		return this.id;
	}
	 
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
