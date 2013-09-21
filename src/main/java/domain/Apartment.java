package domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	public Long getId() {
		return id;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

}
