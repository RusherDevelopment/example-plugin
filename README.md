## Creating Modules

Modules are core components that define specific functionalities for the client.

### Steps to Create a Module

1. Create a new class that extends `ToggleableModule` ExampleModule extends ToggleableModule {
   &#x20;   public ExampleModule() {
   &#x20;       super("ExampleModule", "An example module", ModuleCategory.MISC);
   &#x20;   }
   }

2. **Register the module inside `ExamplePlugin#onLoad()`**:

   ```java
   @Override
   public void onLoad() {
       INSTANCE = this;
       this.getLogger().info("Loading example core plugin");
       
       final ExampleModule exampleModule = new ExampleModule();
       RusherHackAPI.getModuleManager().registerFeature(exampleModule);
   }
   ```

3. **Add event listeners to the module** (e.g., for rendering or game updates):

   ```java
   @Subscribe
   private void onUpdate(EventUpdate event) {
       // Code executed every game tick
   }
   ```

## Setting Up Configuration

Modules often require user-configurable settings. RusherHack provides various setting types:

- **Boolean Setting:**
  ```java
  private final BooleanSetting exampleBoolean = new BooleanSetting("EnableFeature", true);
  ```
- **Number Setting:**
  ```java
  private final NumberSetting<Double> exampleNumber = new NumberSetting<>("Speed", 1.0, 0.1, 10.0);
  ```
- **Color Setting:**
  ```java
  private final ColorSetting exampleColor = new ColorSetting("Color", Color.RED);
  ```

To register these settings in the module:

```java
this.registerSettings(exampleBoolean, exampleNumber, exampleColor);
```

## Creating Commands

Commands allow interaction with the plugin via the in-game chat.

### Steps to Create a Command

1. **Create a new class that extends `Command`**:
   ```java
   public class ExampleCommand extends Command {
       public ExampleCommand() {
           super("example", "Example command description");
       }
   }
   ```
2. **Define command behavior using `@CommandExecutor`**:
   ```java
   @CommandExecutor
   private String execute() {
       return "Hello from ExampleCommand!";
   }
   ```
3. **Registecommand inside `ExamplePlugin#onLoad()`**:
   ```java
   final ExampleCommand exampleCommand = new ExampleCommand();
   RusherHackAPI.getCommandManager().registerFeature(exampleCommand);
   ```

## Creating HUD Elements

HUD elements display information on-screen.

### Steps to Create a HUD Element

1. **Create a class that extends `ResizeableHudElement`**:
   ```java
   public class ExampleHud extends ResizeableHudElement {
       public ExampleHud() {
           super("ExampleHud");
       }
   }
   ```
2. **Implement the rendering logic**:
   ```java
   @Override
   public void renderContent(RenderContext context, double mouseX, double mouseY) {
       if (this.graphic != null) {
           this.getRenderer().drawGraphicRectangle(this.graphic, 0, 0, this.getWidth(), this.getHeight());
       }
   }
   ```
3. **Register the HUD element inside `ExamplePlugin#onLoad()`**:
   ```java
   final ExampleHud exampleHud = new ExampleHud();
   RusherHackAPI.getHudManager().registerFeature(exampleHud);
   ```
