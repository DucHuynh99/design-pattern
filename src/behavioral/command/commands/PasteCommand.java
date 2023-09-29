package behavioral.command.commands;

import behavioral.command.editor.Editor;

public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isBlank())
            return false;
        backup();
        editor.textField = editor.clipboard;
        return true;
    }
}
