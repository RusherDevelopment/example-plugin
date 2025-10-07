package org.example;

import org.rusherhack.client.api.feature.window.Window;
import org.rusherhack.client.api.render.graphic.TextureGraphic;
import org.rusherhack.client.api.ui.window.content.ComboContent;
import org.rusherhack.client.api.ui.window.content.component.ButtonComponent;
import org.rusherhack.client.api.ui.window.content.component.TextFieldComponent;
import org.rusherhack.client.api.ui.window.view.RichTextView;
import org.rusherhack.client.api.ui.window.view.TabbedView;
import org.rusherhack.client.api.ui.window.view.WindowView;

import java.util.List;

public class ExampleWindow extends Window {

    // Declare window features up here so they can be modified by other code in the class
    private final TabbedView rootView;
    private final RichTextView textView;
    private final TextFieldComponent inputBox;
    private final ButtonComponent sendButton;

    public ExampleWindow() {
        super("Example Window", 200, 100, 400, 300);

        textView = new RichTextView("TextView", this);

        // Create a new combo for side-by-side items
        final ComboContent inputCombo = new ComboContent(this);

        inputBox = new TextFieldComponent(this, "Type text here!", this.getWidth());

        inputBox.setReturnCallback(this::handleInput); // Run the handleInput function when enter is pressed
        sendButton = new ButtonComponent(this, "Send", () -> handleInput(inputBox.getValue()));

        // Add previously created items to the input combo
        inputCombo.addContent(inputBox, ComboContent.AnchorSide.LEFT);
        inputCombo.addContent(sendButton);

        this.rootView = new TabbedView(this, List.of(textView, inputCombo));

        // Attempt to set the icon to a TextureGraphic (PNG file)
        try {
            this.setIcon(new TextureGraphic("exampleplugin/graphics/rh_head.png", 64, 64));
        } catch (Throwable ignored) {
            // Normally, this would be logged as an error.
            // However, the Window class does not have an abstract getLogger as of now.
        }
    }

    // This code runs whenever an input is submitted - by way of enter key (setReturnCallback), or button (sendButton)
    private void handleInput(String input) {
        this.textView.add(input, 0xffffff);
        this.inputBox.setValue("");
    }

    @Override
    public WindowView getRootView() {
        return this.rootView;
    }
}
