package com.a1electronics.ecommerce.dbo;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column (name="ID" , unique=true,nullable=false)
    protected Long id;

	public Long  getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		final BaseEntity other = (BaseEntity) obj;
		if (this.id != null && other.id != null) {
			if (this.id != other.id) {
				return false;
			}
		}
		return true;
	}

}
