package com.springBoot.database.databaseDemo.springjdbc.jdbc;

import com.springBoot.database.databaseDemo.springjdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    class PersonRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
//        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?",new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findByIdName(int id, String name) {
        return jdbcTemplate.queryForObject("select * from person where id = ? and name = ?",new Object[]{id,name}, new BeanPropertyRowMapper<Person>(Person.class));
    }
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?",new Object[]{id});
    }
    public int insertData(Person person) {
        return jdbcTemplate.update("insert into person(id,name, location,birth_date) values(?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
    }
    public int updateData(String name, int id) {
        return jdbcTemplate.update("update person set name = ? where id = ?",new Object[]{name,id});
    }
}
