package net.kinginfotech.service;

import net.kinginfotech.model.TodoData;
import net.kinginfotech.model.TodoItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class TodoItemServiceImp implements TodoItemService {

    //==fields===

    private  final TodoData todoData;

    //==constructor==
    public TodoItemServiceImp  (){
           todoData = new  TodoData();
    }
    @Override
    public void addItem(TodoItem todoItem) {
        todoData.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        TodoItem item = todoData.getItem(id);
        return item;
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        todoData.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
       return todoData;
    }
}
