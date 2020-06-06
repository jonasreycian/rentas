package com.j2m.rentas.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j2m.rentas.enums.UserTypeEnum;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "user_name", length = 20)
	private String userName;
	@Column(name = "password", length = 20)
	private String password;
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "last_name", length = 50)
	private String lastName;
	@Column(name = "user_type")
	private Enum<UserTypeEnum> userType;
	@Column(name = "date_created")
	private Timestamp dateCreated;
	@Column(name = "date_updated")
	private Timestamp dateUpdated;
	@JoinColumn(name = "user_data_id", referencedColumnName = "id")
	@ManyToOne
	private UserDataModel userDataId;
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserModel)) {
            return false;
        }
        UserModel other = (UserModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2m.rentas.model.UserModel[ id=" + id + " ]";
    }
}
