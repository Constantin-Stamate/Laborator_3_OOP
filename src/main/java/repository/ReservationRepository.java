package repository;

import dto.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationRepository {
    private Map<String, Reservation> reservationStore;

    public ReservationRepository() {
        this.reservationStore = new HashMap<>();
    }

    public void createReservation(Reservation reservation) {
        this.reservationStore.put(reservation.getId(), reservation);
    }

    public Reservation retrieveReservation(String id) {
        return this.reservationStore.get(id);
    }

    public void updateReservation(Reservation reservation) {
        this.reservationStore.put(reservation.getId(), reservation);

    }

    public void deleteReservation(String id) {
        this.reservationStore.remove(id);
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(this.reservationStore.values());
    }
}
