package com.ms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 权限表
 * @author maos
 * @created 2014-7-7 下午05:46:56
 */
@Entity
@Table (name = "SYS_PRIVILEGE")
public class SysPrivilege extends BaseEntity {

	private static final long serialVersionUID = 7180496433355729699L;

}
