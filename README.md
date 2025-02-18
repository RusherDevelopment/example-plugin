# RusherHack Example Plugin

An example implementation of a RusherHack plugin. 

RusherHack plugins are custom add-ons written by developers to add new features to RusherHack.

## Setting up the Development Environment

### Installing Java Development Kit (JDK)

For Minecraft versions 1.20.1-1.20.4, you will need to have JDK 17 installed. You can download it [here](https://www.azul.com/downloads/?version=java-17-lts&package=jdk#zulu).

For Minecraft versions 1.20.5 and newer, you will need to have JDK 21 installed. You can download it [here](https://www.azul.com/downloads/?version=java-21-lts&package=jdk#zulu).

### Installing IntelliJ IDEA

IntelliJ IDEA is the preferred Java IDE for rusherhack plugin development.

IntelliJ IDEA can be downloaded from [the official website](https://www.jetbrains.com/idea/download).

The Community edition is recommended because it is free and open-source.

## Clone the repository

In IntelliJ, when creating a new project there is an option to clone a repository:

<img src="https://rusherhack.org/i/zsa4nyb3v3m5ifk8gkyoywak.png" alt="cloning" width="600"/>

In the URL, write the text `https://github.com/RusherDevelopment/example-plugin.git` and press `Clone` 

<img src="https://rusherhack.org/i/2rdwc40q98ihb93lt1yykyw8.png" alt="cloning2" width="600"/>

IntelliJ may prompt you asking if you trust the project. Click `Trust Project` to continue.

You should now have a window that looks like this: 

<img src="https://rusherhack.org/i/vwvie6ljusi2tfunyrmvty7j.png" alt="project" width="800"/>

## Modifying the template

- Open the `gradle.properties` file and modify it to your preferences.
- Open the `src/main/resources/rusherhack-plugin.json` file and modify it to your preferences.
  - The `Plugin-Class` property must match the main class of your plugin.
  - The `Name`, `Version`, and `Minecraft-Versions` properties get automatically filled by the values in the `gradle.properties` file. You can add more Minecraft versions if you wish but compatibility between multiple versions is not guaranteed.

## Building the plugin

To build the plugin .jar file, you can run the `gradle build` task.

1. Click on the elephant icon on the right of the screen (Gradle)
2. Navigate to `Tasks` -> `build` -> `build` and double-click it: 

<img src="https://rusherhack.org/i/jkdw12a3wtsz9vvwpvujo9px.png" alt="gradle" width="400"/>

3. The compiled plugin .jar file will be located in the `build/libs` directory: 

<img src="https://rusherhack.org/i/lfwho6o6vrqc4c3znl3pm60v.png" alt="build" width="400"/>

To install the plugin into RusherHack, you can follow the instructions on the [RusherHack plugins repository](https://github.com/RusherDevelopment/rusherhack-plugins?tab=readme-ov-file#installation)
