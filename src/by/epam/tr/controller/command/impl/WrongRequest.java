package by.epam.tr.controller.command.impl;

import by.epam.tr.controller.command.Command;

public class WrongRequest implements Command {
	@Override
	public String execute(String request) {
		return "Wrong Request";
	}
}
