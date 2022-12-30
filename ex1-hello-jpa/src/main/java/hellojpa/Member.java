package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Member {

	@Id
	private Long id;
	@Column(name = "name", nullable = false)
	private String username;

}
