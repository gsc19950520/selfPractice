package com.design.command;

import com.design.command.command.Command;
import com.design.command.command.NullCommand;

public class Control {

	private Command[] onCommands;
	private Command[] offCommands;
	
	private Command lastCommand;
	
	public Control() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		lastCommand = new NullCommand();
	}
	
	public void addOnAndOffCommand(int slot, Command onCommand, Command offCommand) {
		this.onCommands[slot] = onCommand;
		this.offCommands[slot] = offCommand;
	}
	
	public void on(int slot) {
		onCommands[slot].execute();
		lastCommand = onCommands[slot];
	}
	public void off(int slot) {
		offCommands[slot].execute();
		lastCommand = offCommands[slot];
	}
	
	public void undo() {
		lastCommand.undo();
	}
}
