package com.design.command.command;

import com.design.command.appliance.Doors;

public class DoorsOnCommand implements Command {
	
	private Doors doors;
	
	public DoorsOnCommand(Doors doors) {
		this.doors = doors;
	}

	@Override
	public void execute() {
		doors.on();
	}

	@Override
	public void undo() {
		doors.off();
	}

}
