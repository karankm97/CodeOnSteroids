package org.example.api;

import lombok.NonNull;
import org.example.services.BookingService;
import org.example.services.PaymentsService;

public class PaymentController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public PaymentController(PaymentsService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(@NonNull final String bookingId, @NonNull final String user) {
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(@NonNull final String bookingId, @NonNull final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
