package org.example;

import org.rusherhack.client.api.feature.command.Command;
import org.rusherhack.core.command.annotations.CommandExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Example rusherhack command
 *
 * @author John200410
 */
public class ExampleCommand extends Command {
	
	private final List<String> stringList = new ArrayList<>(Arrays.asList("test1", "test2"));
	
	public ExampleCommand() {
		super("ExampleCommand", "description");
	}
	
	/**
	 * base command that takes in no arguments
	 */
	@CommandExecutor
	private String example() {
		//when return type is String you return the message you want to return to the user
		return "Hello World!";
	}
	
	/**
	 * arguments example
	 */
	@CommandExecutor
	@CommandExecutor.Argument({"string", "boolean"}) //must set argument names
	private String exampleWithArguments(String requiredString, Optional<Boolean> optionalBoolean) {
		return requiredString + " " + optionalBoolean.orElse(false);
	}
	
	/**
	 * sub command examples
	 */
	@CommandExecutor(subCommand = "list")
	private String exampleList() {
		return String.join(", ", this.stringList);
	}
	
	@CommandExecutor(subCommand = "add")
	@CommandExecutor.Argument("string") //must set argument names
	private String addToExampleList(String string) {
		this.stringList.add(string);
		return "Added " + string;
	}
	
	@CommandExecutor(subCommand = {"remove", "del"})
	@CommandExecutor.Argument("string") //must set argument names
	private String removeFromExampleList(String string) {
		if(this.stringList.remove(string)) {
			return "Removed " + string;
		}
		return string + " not found";
	}
	
}
