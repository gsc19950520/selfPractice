package com.design.command;

import com.design.command.appliance.Doors;
import com.design.command.appliance.Light;
import com.design.command.command.Command;
import com.design.command.command.DoorsOffCommand;
import com.design.command.command.DoorsOnCommand;
import com.design.command.command.LightOffCommand;
import com.design.command.command.LightOnCommand;
import com.design.command.command.MarcoCommad;

public class Test {

	public static void main(String[] args) {
//		Control c = new Control();
//		Light light = new Light();
//		LightOnCommand lightOnCommand = new LightOnCommand(light);
//		LightOffCommand lightOffCommand = new LightOffCommand(light);
//		c.addOnAndOffCommand(0, lightOnCommand, lightOffCommand);
//		
//		c.off(0);
//		c.undo();
		
		
		Control c = new Control();
		
		Light light = new Light();
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		Doors doors = new Doors();
		DoorsOnCommand doorsOnCommand = new DoorsOnCommand(doors);
		DoorsOffCommand doorsOffCommand = new DoorsOffCommand(doors);
		Command[] onCs = new Command[] {lightOnCommand , doorsOnCommand};
		Command[] offCs = new Command[] {lightOffCommand , doorsOffCommand};
		
		Command onMarco = new MarcoCommad(onCs);
		Command offMarco = new MarcoCommad(offCs);
		
		c.addOnAndOffCommand(0, onMarco, offMarco);
		
		c.off(0);
		c.on(0);
	}
}
