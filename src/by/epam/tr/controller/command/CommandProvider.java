package by.epam.tr.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.tr.controller.command.impl.AddItem;
import by.epam.tr.controller.command.impl.FindItemByParams;
import by.epam.tr.controller.command.impl.FindItemByString;
import by.epam.tr.controller.command.impl.Sort;
import by.epam.tr.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() {
		repository.put(CommandName.ADD, new AddItem());
		repository.put(CommandName.FIND_BY_PARAM, new FindItemByParams());
		repository.put(CommandName.FIND_BY_STRING,new FindItemByString());
		repository.put(CommandName.SORT, new Sort());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;		
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
