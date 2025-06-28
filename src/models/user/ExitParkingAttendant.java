package models.user;

import enums.UserRole;
import models.ParkingTicket;
import service.ParkingService;
import service.PaymentService;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitParkingAttendant extends User {

    private ParkingService parkingService;
    private PaymentService paymentService;
    public ExitParkingAttendant(String name) {
        super(name, UserRole.PARKING_ATTENDANT);
        this.parkingService = ParkingService.getInstance();
        this.paymentService = PaymentService.getInstance();
    }

    public void performExit(ParkingTicket parkingTicket) {
        float parkingAmount = calculateParkingCharge(parkingTicket);
        boolean isPaymentSuccessful = paymentService.payByCash(parkingAmount);

        if(isPaymentSuccessful) {
            parkingService.performExit(parkingTicket);
        } else {
            System.out.println("Please re-try the payment");
        }
    }

    private float calculateParkingCharge(ParkingTicket parkingTicket) {
        long parkingDuration = Duration.between(LocalDateTime.now(), parkingTicket.getEntryTime()).toHours();
        return parkingDuration * parkingTicket.getParkingSpot().getParkingSpotEnum().getValue();
    }
}
