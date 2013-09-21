package domain;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Apartment extends BaseEntity{

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	public Date getExpiryDate() {
		return expiryDate;
	}

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}
