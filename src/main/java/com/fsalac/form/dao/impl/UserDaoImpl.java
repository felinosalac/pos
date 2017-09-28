package com.fsalac.form.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fsalac.form.dao.UserDao;
import com.fsalac.form.model.PosUser;

@Transactional
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	//@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public PosUser findById(Long id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM users WHERE id=:id";

		PosUser result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * User result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<User>());
		 */

		//return result;
		return null;

	}

	@Override
	public List<PosUser> findAll() {

		String sql = "SELECT * FROM users";
		List<PosUser> result = namedParameterJdbcTemplate.query(sql, new UserMapper());

		//return result;
		
		
		return null;

	}

	@Override
	public void save(PosUser user) {

//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		
//		String sql = "INSERT INTO USERS(NAME, EMAIL, ADDRESS, PASSWORD, NEWSLETTER, FRAMEWORK, SEX, NUMBER, COUNTRY, SKILL) "
//				+ "VALUES ( :name, :email, :address, :password, :newsletter, :framework, :sex, :number, :country, :skill)";
//
//		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
//		user.setId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(PosUser user) {

//		String sql = "UPDATE USERS SET NAME=:name, EMAIL=:email, ADDRESS=:address, " + "PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework, "
//				+ "SEX=:sex, NUMBER=:number, COUNTRY=:country, SKILL=:skill WHERE id=:id";
//
//		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM USERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	private SqlParameterSource getSqlParameterByModel(PosUser user) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("id", user.getId());
//		paramSource.addValue("name", user.getName());
//		paramSource.addValue("email", user.getEmail());
//		paramSource.addValue("address", user.getAddress());
//		paramSource.addValue("password", user.getPassword());
//		paramSource.addValue("newsletter", user.isNewsletter());
//
//		// join String
//		paramSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
//		paramSource.addValue("sex", user.getSex());
//		paramSource.addValue("number", user.getNumber());
//		paramSource.addValue("country", user.getCountry());
//		paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));

		return paramSource;
	}

	private static final class UserMapper implements RowMapper<PosUser> {

		public PosUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			PosUser user = new PosUser();
//			user.setId(rs.getInt("id"));
//			user.setName(rs.getString("name"));
//			user.setEmail(rs.getString("email"));
//			user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
//			user.setAddress(rs.getString("address"));
//			user.setCountry(rs.getString("country"));
//			user.setNewsletter(rs.getBoolean("newsletter"));
//			user.setNumber(rs.getInt("number"));
//			user.setPassword(rs.getString("password"));
//			user.setSex(rs.getString("sex"));
//			user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
			return user;
		}
	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}

	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PosUser> findAllUsers() {
		
		Criteria entityCriteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(PosUser.class);
		
		Criteria criteria = entityCriteria.addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<PosUser> users = (List<PosUser>) criteria.list();
         
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
	}
	
	@Autowired
	public void setGenericDAOHibernate(final SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public PosUser findByUserName(String username) {

		List<PosUser> users = new ArrayList<PosUser>();

		users = getHibernateTemplate().getSessionFactory().getCurrentSession()
			.createQuery("from PosUser where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}