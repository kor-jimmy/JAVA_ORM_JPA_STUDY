package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// 상속관계 매핑 테이블 전략 어노테이션. 부모 객체에서 정의
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
