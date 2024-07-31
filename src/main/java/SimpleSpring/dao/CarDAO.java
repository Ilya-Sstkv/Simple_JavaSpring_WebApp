package SimpleSpring.dao;

import java.util.List;
import SimpleSpring.models.Car;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CarDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index(){
        return jdbcTemplate.query("SELECT * FROM cars", new CarMapper());
    }

    public Car show(int id){
        return jdbcTemplate.query("SELECT * FROM cars WHERE id=?", new Object[]{id},
                new CarMapper()).stream().findAny().orElse(null);
    }

    public void save(Car car){
        //Finding and setting the smallest available ID
        int maxId = 0;
        for(Car c: index()){
            if(c.getId()> maxId) maxId = c.getId();
        }
        String setval = "SELECT setval ('cars_id_seq', " + maxId + ")";
        jdbcTemplate.execute(setval);

        jdbcTemplate.update("INSERT INTO cars (car_name, model, wheel_num) VALUES (?, ?, ?)",
                car.getName(), car.getModel(), car.getWheelNum());
    }

    public void update(int id, Car car){
        jdbcTemplate.update("UPDATE cars SET car_name=?, model=?, wheel_num=? WHERE id=?",
                car.getName(), car.getModel(), car.getWheelNum(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM cars WHERE id=?", id);
    }
}