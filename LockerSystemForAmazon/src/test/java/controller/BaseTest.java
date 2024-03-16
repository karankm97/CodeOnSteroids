package controller;

import org.example.controller.LockerController;
import org.example.controller.OrderController;
import org.example.repository.ILockerRepository;
import org.example.repository.LockerRepositoryInMemory;
import org.example.repository.SlotOtpRepositoryInMemory;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;
import org.example.strategies.*;
import org.junit.Before;
import org.mockito.Mock;

public class BaseTest {
    public LockerController lockerController;
    public OrderController orderController;
    public OtpService otpService;
    public LockerService lockerService;

    @Mock
    public NotificationService notificationService;

    @Before
    public void setup() {

         RandomGeneratorDefault randomGeneratorDefault = new RandomGeneratorDefault();
         ISlotAssignmentStrategy lockerAssignmentStrategy = new SlotAssignmentStrategyRandom(randomGeneratorDefault);
         ILockerRepository lockerRepository = new LockerRepositoryInMemory();
         ISlotFilteringStrategy slotFilteringStrategy = new SlotFilteringStrategySizeBased();
         SlotOtpRepositoryInMemory slotOtpRepository = new SlotOtpRepositoryInMemory();
         OtpGeneratorRandom otpGeneratorRandom = new OtpGeneratorRandom(5, randomGeneratorDefault);

        this.lockerService = new LockerService(lockerAssignmentStrategy, lockerRepository, slotFilteringStrategy);
        this.otpService = new OtpService(otpGeneratorRandom, slotOtpRepository);

        this.lockerController = new LockerController(lockerService, otpService);
        this.orderController = new OrderController(notificationService, otpService, lockerService);
    }
}
