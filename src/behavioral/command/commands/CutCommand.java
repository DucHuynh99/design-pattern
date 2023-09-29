package behavioral.command.commands;

import behavioral.command.editor.Editor;

public class CutCommand extends Command {

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.textField == null || editor.textField.isBlank())
            return false;
        backup();
        editor.clipboard = editor.textField;
        editor.textField = null;
        return true;
    }
}
