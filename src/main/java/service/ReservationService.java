package service;

import dto.Reservation;

import java.math.BigDecimal;
import java.util.List;

public interface ReservationService {
    void createReservation(Reservation reservation);
    Reservation retrieveReservation(String id);
    void updateReservation(Reservation reservation);
    void changeStatus(String id);
    BigDecimal calculateTotalCost(String id);
    List<Reservation> getAllReservations();
}
