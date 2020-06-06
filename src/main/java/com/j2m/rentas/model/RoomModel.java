package com.j2m.rentas.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j2m.rentas.enums.RoomStatusEnum;
import lombok.Data;

@Table(name = "rooms")
@Data
public class RoomModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "capacity")
	private Integer capacity;
	@Column(name = "status")
	private Enum<RoomStatusEnum> status;
	@Column(name = "room_type")
	private String roomType;
	@Column(name = "room_price")
	private BigDecimal roomPrice;
	

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomModel)) {
            return false;
        }
        RoomModel other = (RoomModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2m.rentas.model.RoomModel[ id=" + id + " ]";
    }
}
