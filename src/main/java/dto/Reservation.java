package dto;

import constants.ReservationStatus;
import constants.ReservationType;

public abstract class Reservation {
    private String id;
    private String name;
    private final ReservationType type;
    private ReservationStatus status;

    public Reservation(String id, String name, ReservationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = ReservationStatus.PENDING;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReservationType getType() {
        return type;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public abstract Reservation clone();
}
