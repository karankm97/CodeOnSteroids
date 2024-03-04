package org.example.commands;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.model.Slot;
import org.example.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ColorsToSlotNumberCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "slot_numbers_for_cars_with_color";

    public ColorsToSlotNumberCommandExecutor (final ParkingLotService parkingLotService,
                                            final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(final Command command) {
        final List<Slot> slotForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));
        if(slotForColor.isEmpty()) {
            outputPrinter.notFound();
        } else {
            final String result =
                    slotForColor.stream()
                            .map(slot -> slot.getSlotNumber().toString())
                            .collect(Collectors.joining(", "));
            outputPrinter.printWithNewLine(result);
        }
    }
}
