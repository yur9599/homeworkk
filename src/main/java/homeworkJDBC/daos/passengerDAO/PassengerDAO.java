package homeworkJDBC.daos.passengerDAO;

import homeworkJDBC.entities.PassInTrip;
import homeworkJDBC.entities.Passenger;
import homeworkJDBC.entities.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerDAO {

    Passenger getById(long id);

    Set<Passenger> getAll();

    Set<Passenger> get(int offset, int perPage, String sort);

    Passenger save(Passenger passenger);

    Passenger update(int id, Passenger passenger);

    void delete(long passengerId);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(PassInTrip passInTrip);

    void cancelTrip(long passengerId, long tripNumber);

}
