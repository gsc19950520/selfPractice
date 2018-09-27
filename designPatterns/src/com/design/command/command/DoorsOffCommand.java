package com.design.command.command;

import com.design.command.appliance.Doors;

public class DoorsOffCommand implements Command {

	private Doors doors;
	
	public DoorsOffCommand(Doors doors) {
		this.doors = doors;
	}

	@Override
	public void execute() {
		doors.off();
	}

	@Override
	public void undo() {
		doors.on();
	}

}
