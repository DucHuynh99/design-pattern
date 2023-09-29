package behavioral.command.commands;

import behavioral.command.editor.Editor;

public abstract class Command {
    public final Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField;
    }

    public abstract boolean execute();

    public void undo() {
        editor.textField = backup;
    }
}
