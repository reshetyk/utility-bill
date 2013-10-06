package domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Apartment extends BaseEntity{

    private String name;

    public Apartment(String name) {
        this.name = name;
    }

    public Apartment() {
    }

    @Temporal(TemporalType.DATE)
	private Date expiryDate;

	public Date getExpiryDate() {
		return expiryDate;
	}

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("new", this.isNew())
                .toString();
    }
}
