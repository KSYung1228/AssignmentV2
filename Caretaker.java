
/*
 * This class is the caretaker for memento pattern
 * Stack<memento> to save the stage, getDescription to show the action
 */
import java.util.Stack;

public class Caretaker {
    // set memento to stack,and create teack
    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();
    private final Stack<Memento> historyUndoList = new Stack<>();
    private final Stack<Memento> historyRedoList = new Stack<>();

    // collent the action from command
    public void pushCommand(Memento command) {
        undoStack.push(command);
        redoStack.clear();
    }

    // undo action
    public void undo() {
        if (!undoStack.isEmpty()) {
            Memento command = undoStack.pop();
            command.undo();
            historyUndoList.push(command);
            redoStack.push(command);
        }
    }

    // redo action
    public void redo() {
        if (!redoStack.isEmpty()) {
            Memento command = redoStack.pop();
            command.redo();
            historyRedoList.push(command);
            undoStack.push(command);
        }
    }

    // show the undo list to system
    public void showUndoList() {
        System.out.println("Undo List");
        for (Memento command : undoStack) {
            System.out.println(command.getDescription());
        }
        System.out.println("-- End of undo list --");
    }

    // show the redo list to system
    public void showRedoList() {
        System.out.println("Redo List");
        for (Memento command : redoStack) {
            System.out.println(command.getDescription());
        }
        System.out.println("-- End of redo list --");
    }

    // not to use, but can show the recent action for undo
    public void showHistoryUndoList() {
        System.out.println("Undo List");
        for (Memento memento : historyUndoList) {
            System.out.println("-- " + memento.getDescription());
        }
        System.out.println("-- End of undo list --");
    }

    // not to use, but show the recent action for redo
    public void showHistoryRedoList() {
        System.out.println("Redo List");
        for (Memento memento : historyRedoList) {
            System.out.println("-- " + memento.getDescription());
        }
        System.out.println("-- End of redo list --");
    }
}