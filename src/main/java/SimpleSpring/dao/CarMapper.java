package SimpleSpring.dao;

import SimpleSpring.models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setName(resultSet.getString("car_name"));
        if(resultSet.getString("model").isEmpty())
            car.setModel("unknown");
        else car.setModel(resultSet.getString("model"));
        car.setWheelNum(resultSet.getInt("wheel_num"));
        return car;
    }
}