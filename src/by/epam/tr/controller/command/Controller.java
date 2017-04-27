package by.epam.tr.controller.command;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	private final char delimeter = '-';
	
	public String executeTask(String request) {
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(delimeter));
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request.substring(request.indexOf(delimeter) + 1));
		
		return response;
	}
	
}
