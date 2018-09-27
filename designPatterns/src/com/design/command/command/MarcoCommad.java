package com.design.command.command;

public class MarcoCommad implements Command{
	
	private Command[] commands;
	
	public MarcoCommad(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for(Command c : commands) {
			c.execute();
		}
	}

	@Override
	public void undo() {
		
	}

}
