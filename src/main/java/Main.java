import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dto.EventReservation;
import dto.HotelReservation;
import constants.ReservationType;
import repository.ReservationRepository;
import service.EventReservationService;
import service.HotelReservationService;

public class Main {

    static Path[] paths = new Path[]{
            Paths.get("src/main/resources/reservations.txt"),
            Paths.get("src/main/resources/modifications.txt")
    };

    static ReservationRepository reservationRepository = new ReservationRepository();
    static HotelReservationService hotelService = new HotelReservationService(reservationRepository);
    static EventReservationService eventService = new EventReservationService(reservationRepository);

    public static void main(String[] args) {
        try {
            loadReservations();
            applyModifications();
            printReservations();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void loadReservations() throws IOException {
        Files.lines(paths[0])
                .forEach(line -> {
                    String[] words = line.split(" ");
                    if (words[0].equals("HOTEL")) {
                        hotelService.createReservation(new HotelReservation(words[1], words[2], ReservationType.HOTEL, new BigDecimal(words[3])));
                    } else {
                        eventService.createReservation(new EventReservation(words[1], words[2], ReservationType.EVENT, new BigDecimal(words[3])));
                    }
                });
    }

    public static void applyModifications() throws IOException {
        Files.lines(paths[1])
                .forEach(line -> {
                    String[] words = line.split(" ");
                    if (words[0].equals("EVENT") && words[2].equals("PENDING")) {
                        eventService.changeStatus(words[1]);
                    } else if (words[0].equals("HOTEL") && words[2].equals("PENDING")) {
                        hotelService.changeStatus(words[1]);
                    }
                });
    }

    public static void printReservations() {
        System.out.println("Remaining Hotel Reservations:");
        hotelService.getAllReservations().forEach(reservation -> {
            if (reservation instanceof HotelReservation) {
                HotelReservation hotelReservation = (HotelReservation) reservation;
                System.out.println("ID: " + hotelReservation.getId() +
                        ", Name: " + hotelReservation.getName() +
                        ", Room Rate: " + hotelReservation.getRoomRate() +
                        ", Status: " + hotelReservation.getStatus());
            }
        });

        System.out.println("\nRemaining Event Reservations:");
        eventService.getAllReservations().forEach(reservation -> {
            if (reservation instanceof EventReservation) {
                EventReservation eventReservation = (EventReservation) reservation;
                System.out.println("ID: " + eventReservation.getId() +
                        ", Name: " + eventReservation.getName() +
                        ", Cost: " + eventReservation.getCost() +
                        ", Status: " + eventReservation.getStatus());
            }
        });
    }
}

