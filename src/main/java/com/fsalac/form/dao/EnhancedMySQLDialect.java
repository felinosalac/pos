package com.fsalac.form.dao;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

/**
 * User: rmorgan
 * Date: 10/28/14
 * Time: 9:15 PM
 */
public class EnhancedMySQLDialect extends MySQLDialect {

	public EnhancedMySQLDialect(){
		super();
		registerFunction("group_concat", new StandardSQLFunction("group_concat", new StringType()));
	}

}
