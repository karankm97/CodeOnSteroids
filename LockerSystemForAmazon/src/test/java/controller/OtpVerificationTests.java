package controller;

import org.example.model.Buyer;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;
import utils.LockerUtils;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static utils.BuyerUtils.randomBuyer;
import static utils.RandomUtils.randomOtp;

@RunWith(MockitoJUnitRunner.class)
public class OtpVerificationTests extends BaseTest {
    @Test
    public void testOtpWorksCorrectly() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
         Buyer buyer = randomBuyer();
         LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
         Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        ArgumentCaptor<String> otpCaptor = ArgumentCaptor.forClass(String.class);
        verify(notificationService).notifyUser(eq(buyer), otpCaptor.capture(), eq(slot));
         String otp = otpCaptor.getValue();
        assertNotNull(otp);
        boolean isSuccess = lockerController.unlockSlot(slot, otp);

        assertTrue(isSuccess);
    }

    @Test
    public void testInvalidOtpDoesNotUnlocksSlot() {

        // Arrange
        LockerUtils.createTestLockerWithSlots(lockerController, 2, new Size(10.0, 10.0));
         Buyer buyer = randomBuyer();
         LockerItem item = LockerUtils.randomLockerItem(new Size(5.0, 5.0));

        // Act
         Slot slot = orderController.allocateLocker(buyer, item);

        // Assert
        boolean isSuccess = lockerController.unlockSlot(slot, randomOtp());

        assertFalse(isSuccess);
    }

}
