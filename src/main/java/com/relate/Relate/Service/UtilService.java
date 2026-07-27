package com.relate.Relate.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UtilService {
    private final JdbcTemplate jdbcTemplate;

    public UtilService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean checkUser(String username){
        String sql = "select * from user_table where username = ?";
        RowMapper<Boolean> rowMapper = (rs, nowNum) ->
                rs.getString("username") != null;

        try {
            boolean result = Boolean.TRUE.equals(jdbcTemplate
                    .queryForObject(
                            sql,
                            (rs, nowNum) -> {
                                return rs.getString("username") != null;
                            },
                            username));
            return result;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
