package uy.edu.ort.agenda.utils;

import java.util.List;

public class Commands {
    private List<Command> commands;

    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
