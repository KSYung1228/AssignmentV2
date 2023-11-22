import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();
    private final Stack<Memento> historyUndoList = new Stack<>();
    private final Stack<Memento> historyRedoList = new Stack<>();

    public void pushCommand(Memento command) {
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Memento command = undoStack.pop();
            command.undo();
            historyUndoList.push(command);
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Memento command = redoStack.pop();
            command.redo();
            historyRedoList.push(command);
            undoStack.push(command);
        }
    }

    public void showUndoList() {
        System.out.println("Undo List");
        for (Memento command : undoStack) {
            System.out.println(command.getDescription());
        }
        System.out.println("-- End of undo list --");
    }

    public void showRedoList() {
        System.out.println("Redo List");
        for (Memento command : redoStack) {
            System.out.println(command.getDescription());
        }
        System.out.println("-- End of redo list --");
    }

    public void showHistoryUndoList() {
        System.out.println("Undo List");
        for (Memento memento : historyUndoList) {
            System.out.println("-- " + memento.getDescription());
        }
        System.out.println("-- End of undo list --");
    }

    public void showHistoryRedoList() {
        System.out.println("Redo List");
        for (Memento memento : historyRedoList) {
            System.out.println("-- " + memento.getDescription());
        }
        System.out.println("-- End of redo list --");
    }
}