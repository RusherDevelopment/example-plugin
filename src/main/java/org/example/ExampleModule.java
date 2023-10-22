package org.example;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.events.client.EventUpdate;
import org.rusherhack.client.api.events.render.EventRender2D;
import org.rusherhack.client.api.events.render.EventRender3D;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.client.api.render.IRenderer2D;
import org.rusherhack.client.api.render.IRenderer3D;
import org.rusherhack.client.api.render.font.IFontRenderer;
import org.rusherhack.client.api.setting.BindSetting;
import org.rusherhack.client.api.setting.ColorSetting;
import org.rusherhack.client.api.utils.ChatUtils;
import org.rusherhack.client.api.utils.WorldUtils;
import org.rusherhack.core.bind.key.NullKey;
import org.rusherhack.core.event.subscribe.Subscribe;
import org.rusherhack.core.setting.BooleanSetting;
import org.rusherhack.core.setting.NumberSetting;
import org.rusherhack.core.setting.StringSetting;
import org.rusherhack.core.utils.ColorUtils;

import java.awt.*;

/**
 * Example rusherhack module
 *
 * @author John200410
 */
public class ExampleModule extends ToggleableModule {
	
	/**
	 * Settings
	 */
	private final BooleanSetting exampleBoolean = new BooleanSetting("Boolean", "Settings can optionally have a description", true);
	
	private final NumberSetting<Double> exampleDouble = new NumberSetting<>("Double", 0.0, -10.0, 10.0)
			
			//specifies incremental step for precise numbers
			.incremental(0.1)
			
			//predicate that determines conditions for the setting to be visible in the clickgui
			.setVisibility(this.exampleBoolean::getValue)
			
			//consumer that is called when the setting is changed
			.onChange(d -> ChatUtils.print("Changed double to " + d));
	
	private final ColorSetting exampleColor = new ColorSetting("Color", Color.CYAN)
			
			//set whether alpha is enabled in the color picker
			.setAlphaAllowed(false)
			
			//sync the color with the theme color
			.setThemeSync(true);
	
	private final StringSetting exampleString = new StringSetting("String", "Hello World!")
			
			//disables the rendering of the setting name in the clickgui
			.setNameVisible(false);
	
	private final BindSetting rotate = new BindSetting("RotateBind", NullKey.INSTANCE /* unbound */);
	private final NumberSetting<Float> rotateYaw = new NumberSetting<>("Yaw", 0f, 0f, 360f).incremental(0.1f);
	private final NumberSetting<Float> rotatePitch = new NumberSetting<>("Pitch", 0f, -90f, 90f).incremental(0.1f);
	
	/**
	 * Constructor
	 */
	public ExampleModule() {
		super("Example", "Example plugin module", ModuleCategory.CLIENT);
		
		//subsettings
		this.rotate.addSubSettings(this.rotateYaw, this.rotatePitch);
		
		//register settings
		this.registerSettings(
				this.exampleBoolean,
				this.exampleDouble,
				this.exampleColor,
				this.exampleString,
				this.rotate
		);
	}
	
	/**
	 * 2d renderer demo
	 */
	@Subscribe
	private void onRender2D(EventRender2D event) {
		
		//renderers
		final IRenderer2D renderer = RusherHackAPI.getRenderer2D();
		final IFontRenderer fontRenderer = RusherHackAPI.fonts().getFontRenderer();
		
		//must begin renderer first
		renderer.begin(event.getMatrixStack(), fontRenderer);
		
		//draw stuff
		renderer.drawRectangle(100, 100 + this.exampleDouble.getValue(), 100, 100, this.exampleColor.getValueRGB());
		fontRenderer.drawString(this.exampleString.getValue(), 110, 110, Color.WHITE.getRGB());
		
		//end renderer
		renderer.end();
		
	}
	
	/**
	 * Rotation demo
	 */
	@Subscribe
	private void onUpdate(EventUpdate event) {
		
		//only rotate while bind is held
		if(this.rotate.getValue().isKeyDown()) {
			
			//loop through entities to find a target
			Entity target = null;
			double dist = 999d;
			for(Entity entity : WorldUtils.getEntitiesSorted()) {
				if(mc.player.distanceTo(entity) < dist && entity instanceof LivingEntity) {
					target = entity;
					dist = mc.player.distanceTo(entity);
				}
			}
			
			//rotate to target
			if(target != null) {
				RusherHackAPI.getRotationManager().updateRotation(target);
			} else { //or rotate to the custom yaw
				RusherHackAPI.getRotationManager().updateRotation(this.rotateYaw.getValue(), this.rotatePitch.getValue());
			}
		}
	}
	
	//3d renderer demo
	@Subscribe
	private void onRender3D(EventRender3D event) {
		final IRenderer3D renderer = event.getRenderer();
		
		final int color = ColorUtils.transparency(this.exampleColor.getValueRGB(), 0.5f); //fill colors look better when the alpha is not 100%
		
		//begin renderer
		renderer.begin(event.getMatrixStack());
		
		//highlight targets
		for(Entity entity : WorldUtils.getEntities()) {
			renderer.drawBox(entity, event.getPartialTicks(), true, true, color);
		}
		
		//end renderer
		renderer.end();
	}
	
	@Override
	public void onEnable() {
		if(mc.level != null) {
			ChatUtils.print("Hello World! Example module is enabled");
		}
	}
	
	@Override
	public void onDisable() {
		if(mc.level != null) {
			ChatUtils.print("Goodbye World! Example module has been disabled");
		}
	}
}
