package org.example.mode;

import org.example.OutputPrinter;
import org.example.commands.CommandExecutorFactory;
import org.example.commands.ExitCommandExecutor;
import org.example.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{
    public InteractiveMode (
            final CommandExecutorFactory commandExecutorFactory,
            final OutputPrinter outputPrinter
            ) {
        super(commandExecutorFactory, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);
            if(command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
