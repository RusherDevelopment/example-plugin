 Rusherhack Example Plugin

This is an example plugin that shows how to use Rusherhack's plugin API. 

## Building:

### Option 1: Intelij IDEA
1. Download [intelij idea community edition](https://www.jetbrains.com/idea/download). Make sure to scroll down to community edition - pro costs money
2. Install idea using whatever method you downloaded and run it
3. It should look like this. Click "clone repository" and type in `https://github.com/john200410/example-plugin`

![image](https://github.com/user-attachments/assets/8fc7803a-423d-4d54-8022-98b0543e4817)

4. Once it is done cloning (downloading) click on "trust project" and it should up the ide window

![image](https://github.com/user-attachments/assets/8fc7803a-423d-4d54-8022-98b0543e4817)

5. Click on the little elephant in the corner (Gradle)

![image](https://github.com/user-attachments/assets/7f65b23e-42ce-4a36-b185-e235860c5220)

6. Click on the button that a box with a play button and then type "build" in the text box that pops up

![image](https://github.com/user-attachments/assets/f53ada2a-0e4f-4617-af26-5c2d4b680858)

7. Press enter. A window should pop up in the bottom with a bunch of text info.

![image](https://github.com/user-attachments/assets/e1679529-06ee-40f4-94fd-044ad09276f1)

8. Once this is done (it should finish successfully, if it is unsuccessful, please ask in #plugins-dev) your compiled jar should be in the build/libs folder of the project folder. 

9. You can open up the project folder using file explorer, and use that jar as you would with any other plugin (see [Rusherhack Plugins](https://github.com/RusherDevelopment/rusherhack-plugins/blob/main/README.md))

   
### Option 2: Linux command line

1. This method only works on Linux, WSL, and probably git bash. NOT POWERSHELL
2. Open up terminal and run these commands in order
```
git clone https://github.com/john200410/example-plugin
cd example-plugin
chmod +x gradlew
./gradlew build
```
3. If something goes wrong in any of these steps, you may not have java installed. Install something around the lines of `jdk21-openjdk` from your package manager. If more goes wrong, please ask in #plugins-dev
4. Your compiled jar file should be in the build/libs subdirectory of the project folder.
5. You can use that jar as you would with any other plugin (see [Rusherhack Plugins](https://github.com/RusherDevelopment/rusherhack-plugins/blob/main/README.md))
![image](https://github.com/user-attachments/assets/470b84fd-10c4-48fc-827c-c88c6d635ab2)
