public interface Memento {
    String getDescription();

    public void undo();

    public void redo();
}