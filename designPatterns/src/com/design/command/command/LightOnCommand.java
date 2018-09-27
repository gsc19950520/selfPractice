package com.design.command.command;

import com.design.command.appliance.Light;

public class LightOnCommand implements Command {
	
	private Light light;
	
	public LightOnCommand(Light light){
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}

}
