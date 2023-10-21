package org.example;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

/**
 * Example rusherhack plugin
 *
 * @author John200410
 */
public class ExamplePlugin extends Plugin {
	
	@Override
	public void onLoad() {
		
		//logger
		this.getLogger().info(this.getName() + " loaded!");
		this.getLogger().info("Hello World!");
		
		//creating and registering a new module
		final ExampleModule exampleModule = new ExampleModule();
		RusherHackAPI.getModuleManager().registerFeature(exampleModule);
		
		//creating and registering a new hud element
		final ExampleHudElement exampleHudElement = new ExampleHudElement();
		RusherHackAPI.getHudManager().registerFeature(exampleHudElement);
		
		//creating and registering a new command
		final ExampleCommand exampleCommand = new ExampleCommand();
		RusherHackAPI.getCommandManager().registerFeature(exampleCommand);
	}
	
	@Override
	public void onUnload() {
		this.getLogger().info(this.getName() + " unloaded!");
	}
	
	@Override
	public String getName() {
		return "Example";
	}
	
	@Override
	public String getVersion() {
		return "v1.0";
	}
	
	@Override
	public String getDescription() {
		return "Example rusherhack plugin";
	}
	
	@Override
	public String[] getAuthors() {
		return new String[]{"John200410"};
	}
}
