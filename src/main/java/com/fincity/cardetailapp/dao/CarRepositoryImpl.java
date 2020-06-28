package com.fincity.cardetailapp.dao;

import com.fincity.cardetailapp.enitities.CarEntity;
import com.fincity.cardetailapp.enums.CarSearchEnum;
import com.fincity.cardetailapp.utility.CarDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRepositoryImpl implements CarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(CarEntity car) {
        return jdbcTemplate.update("INSERT INTO car_detail(name,manufacture_name,model,manufacture_year,color) VALUES(?,?,?,?,?)",
                new Object[] {
                        car.getName(), car.getManufactureName(),car.getModel(),car.getManufactureYear(),car.getColor()
                });
    }

    @Override
    public CarEntity findById(Long id) {
        return jdbcTemplate.queryForObject("select * from car_detail where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< CarEntity >(CarEntity.class));
    }

    @Override
    public List< CarEntity > findAll() {
        return jdbcTemplate.query("select * from car_detail", new CarDetailMapper());
    }


    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from car_detail where id=?", new Object[] {
                id
        });
    }

    @Override
    public int update(CarEntity carEntity) {
        return jdbcTemplate.update("update car_detail " + " set name = ?, manufacture_name = ?,model = ?,manufacture_year = ?,color = ? " + " where id = ?",
                new Object[] {
                        carEntity.getName(), carEntity.getManufactureName(),carEntity.getModel(),carEntity.getManufactureYear(),carEntity.getColor(), carEntity.getId()
                });
    }


    @Override
    public List< CarEntity > searchBy(CarSearchEnum carSearchEnum, Object value) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from car_detail where ");
        buildQuery(sb,carSearchEnum,value);
        return jdbcTemplate.query(sb.toString(), new CarDetailMapper());
    }

    private void buildQuery(StringBuilder query,CarSearchEnum carSearchEnum, Object value){
        if (CarSearchEnum.COLOR==carSearchEnum){
            query.append("color like ").append("'%").append(carSearchEnum.getConvertType().apply(value)).append("%';");
        }else if(CarSearchEnum.MANUFACTURE_YEAR==carSearchEnum){
            query.append("manufacture_year =").append(carSearchEnum.getConvertType().apply(value));
        }else if(CarSearchEnum.MANUFACTURE_NAME==carSearchEnum){
            query.append("manufacture_name like ").append("'%").append(carSearchEnum.getConvertType().apply(value)).append("%';");
        }else if(CarSearchEnum.NAME==carSearchEnum){
            query.append("name like").append("'%").append(carSearchEnum.getConvertType().apply(value)).append("%';");
        }else if(CarSearchEnum.MODEL==carSearchEnum){
            query.append("model like").append("'%").append(carSearchEnum.getConvertType().apply(value)).append("%';");
        }
    }

}
