package br.josets.foodserviceexample.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserOrder {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<OrderItem> items = new HashSet<>();
	
	@ManyToOne
	private ServiceUser serviceUser;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public ServiceUser getServiceUser() {
		return serviceUser;
	}

	public void setServiceUser(ServiceUser user) {
		this.serviceUser = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((serviceUser == null) ? 0 : serviceUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserOrder other = (UserOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (serviceUser == null) {
			if (other.serviceUser != null)
				return false;
		} else if (!serviceUser.equals(other.serviceUser))
			return false;
		return true;
	}
	
}
