package homeworkJDBC.daos.tripDAO;

import homeworkJDBC.entities.Trip;

import java.util.List;
import java.util.Set;

public interface TripDAO {

    Trip getById(long id);

    Set<Trip> getAll();

    Set<Trip> get(int offset, int perPage, String sort);

    Trip save(Trip trip);

    Trip update(String tripNo, Trip trip);

    void delete(long tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);

}
