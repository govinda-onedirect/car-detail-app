package com.fincity.cardetailapp.utility;

import com.fincity.cardetailapp.enitities.CarEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDetailMapper implements RowMapper<CarEntity>{

        @Override
        public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            CarEntity carEntity = new CarEntity();
            carEntity.setId(rs.getLong("id"));
            carEntity.setName(rs.getString("name"));
            carEntity.setManufactureName(rs.getString("manufacture_name"));
            carEntity.setManufactureYear(rs.getInt("manufacture_year"));
            carEntity.setModel(rs.getString("model"));
            carEntity.setColor(rs.getString("color"));
            return carEntity;
        }

}
