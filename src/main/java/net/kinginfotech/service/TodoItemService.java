package net.kinginfotech.service;

import net.kinginfotech.model.TodoData;
import net.kinginfotech.model.TodoItem;

public interface TodoItemService {
    public void addItem(TodoItem todoItem);
    public void removeItem(int id);
    public TodoItem getItem(int id);
    public void updateItem(TodoItem toUpdate);
    public TodoData getData();
}
