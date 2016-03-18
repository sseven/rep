package com.ms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;


/**
 *  不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 *  单表继承（InheritanceType.SINGLETABLE），所有继承树上的类共用一张表，在父类指定（@DiscriminatorColumn）声明并在每个类指定@DiscriminatorValue来区分类型。
 *	类表继承（InheritanceType.JOINED），父子类共同的部分公用一张表，其余部分保存到各自的表，通过join进行关联。
 *	具体表继承（InheritanceType.TABLEPERCLASS)，每个具体类映射到自己的表。
 */
@MappedSuperclass
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 6258404632281308134L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDHexGenerator")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", length = 32)
	@AccessType("property")
	protected String id;
	
	//	防止乐观锁
	@Version
	protected int version;
	
	//	
	@Column(name = "NAME", length = 250)
	protected String name;
	
	//	创建人ID
	@Column(name = "CREATOR", length = 32)
	protected String creator;
	
	//	修改人ID
	@Column(name = "MODIFIER", length = 32)
	protected String modifier;
	
	//	创建时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	protected Date createDate;
	
	//	修改时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE", length = 19)
	protected Date modifyDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
