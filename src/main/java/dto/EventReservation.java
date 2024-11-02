package dto;

import constants.ReservationType;
import java.math.BigDecimal;

public class EventReservation extends Reservation {
    private BigDecimal cost;

    public EventReservation(String id, String nume, ReservationType type, BigDecimal cost) {
        super(id, nume, ReservationType.EVENT);
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public Reservation clone() {
        return new EventReservation(super.getId(), super.getName(), super.getType(), this.cost);
    }
}

