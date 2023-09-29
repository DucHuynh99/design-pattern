package behavioral.command.editor;

import behavioral.command.commands.Command;

import java.util.Stack;

public class Editor {
    public String textField;
    public String clipboard;
    private final Stack<Command> history;

    public Editor() {
        history = new Stack<>();
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undo() {
        if (history.empty())
            return;
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public void render() {
        System.out.printf("Text: %s | Clipboard: %s\r\n", textField, clipboard);
    }
}
