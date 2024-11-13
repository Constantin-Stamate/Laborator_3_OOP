package dto;

import constants.ReservationType;
import java.math.BigDecimal;

public class HotelReservation extends Reservation {

    private BigDecimal roomRate;

    public HotelReservation(String id, String nume, ReservationType type, BigDecimal roomRate) {
        super(id, nume, ReservationType.HOTEL);
        this.roomRate = roomRate;
    }

    public BigDecimal getRoomRate() {
        return this.roomRate;
    }

    public void setRoomRate(BigDecimal roomRate) {
        this.roomRate = roomRate;
    }

    @Override
    public Reservation clone() {
        return new HotelReservation(super.getId(), super.getName(), super.getType(), this.roomRate);
    }
}