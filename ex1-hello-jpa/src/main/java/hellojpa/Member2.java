package hellojpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Member2 {

	@Id
	private Long id;
	
	// DB 칼럼명과 객체 이름이 다를 경우
	// insertable, updatable 등록, 변경 가능 유무
	// nullable notnull 유무
	// length 길이
	// columnDefinition 칼럼 정보를 직접 넣을 경우
	@Column(name = "name", nullable = false)
	private String username;
	
	private Integer age;
	
	// enum 타입을 사용 할 경우
	// Ordinal 사용 X, enum을 숫자로 저장한다.
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	// 날짜 관련 어노테이션
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	// varchar를 넘어서는 컨텐츠를 사용 할 경우
	@Lob
	private String description;
	
	// DB 칼럼으로 사용하지 않을 때(메모리, 캐시 사용 등)
	@Transient
	private int temp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
