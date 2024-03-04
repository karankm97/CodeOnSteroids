package org.example.commands;

import org.example.OutputPrinter;
import org.example.model.Command;
import org.example.service.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(final ParkingLotService parkingLotService,
                               final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate (final Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(final Command command) {
        outputPrinter.end();
    }
}
