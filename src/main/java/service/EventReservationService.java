package service;

import constants.ReservationStatus;
import dto.EventReservation;
import dto.Reservation;
import repository.ReservationRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EventReservationService implements ReservationService {
    ReservationRepository reservationRepository;

    public EventReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void createReservation(Reservation reservation) {
        this.reservationRepository.createReservation(reservation.clone());
    }

    @Override
    public EventReservation retrieveReservation(String id) {
        return (EventReservation) this.reservationRepository.retrieveReservation(id).clone();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        this.reservationRepository.updateReservation(reservation.clone());
    }

    @Override
    public void changeStatus(String id) {
        Reservation reservation = retrieveReservation(id);
        reservation.setStatus(ReservationStatus.CONFIRMED);
        this.reservationRepository.updateReservation(reservation);
    }

    @Override
    public BigDecimal calculateTotalCost(String id) {
        EventReservation reservation = retrieveReservation(id);
        return reservation.getCost();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.getAllReservations().stream()
                .filter(reservation -> reservation instanceof EventReservation)
                .map(reservation -> (EventReservation) reservation)
                .collect(Collectors.toList());
    }
}


