package com.j2m.rentas.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.j2m.rentas.enums.ExpenseCategoryEnum;
import com.j2m.rentas.enums.ExpenseStatusEnum;

import lombok.Data;

@Data
@Table(name = "room_expenses")
@Entity
public class RoomExpenseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private Enum<ExpenseCategoryEnum> category;
	
	@Column(name = "status")
	private Enum<ExpenseStatusEnum> status;
	
	@Column(name = "comment")
	private String comment;
	
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	@ManyToOne
	private RoomModel roomId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Column(name = "date_updated")
	private Timestamp dateUpdated;

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomExpenseModel)) {
            return false;
        }
        RoomExpenseModel other = (RoomExpenseModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j2m.rentas.model.RoomExpensesModel[ id=" + id + " ]";
    }
}
