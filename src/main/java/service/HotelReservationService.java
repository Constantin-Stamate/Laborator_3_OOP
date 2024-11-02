package service;

import constants.ReservationStatus;
import dto.HotelReservation;
import dto.Reservation;
import repository.ReservationRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationService implements ReservationService {
    ReservationRepository reservationRepository;

    public HotelReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void createReservation(Reservation reservation) {
        this.reservationRepository.createReservation(reservation.clone());
    }

    @Override
    public HotelReservation retrieveReservation(String id) {
        return (HotelReservation) this.reservationRepository.retrieveReservation(id).clone();
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
        HotelReservation reservation = retrieveReservation(id);
        return reservation.getRoomRate();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return this.reservationRepository.getAllReservations().stream()
                .filter(reservation -> reservation instanceof HotelReservation)
                .map(reservation -> (HotelReservation) reservation)
                .collect(Collectors.toList());
    }
}
