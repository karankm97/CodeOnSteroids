package org.example.commands;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.model.ParkingLot;
import org.example.model.parking.strategy.NaturalOrderingParkingStrategy;
import org.example.service.ParkingLotService;
import org.example.validator.IntegerValidator;

import java.util.List;

public class CreateParkingLotCommandExecutor extends  CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(
            final ParkingLotService parkingLotService,
            final OutputPrinter outputPrinter
            ) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if(params.size() != 1) {
            return false;
        }

        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(final Command command) {
        final int parkingLotCapacit = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacit);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine(
                "Created a parking lot with " + parkingLot.getCapacity() + " slots"
        );
    }
}
