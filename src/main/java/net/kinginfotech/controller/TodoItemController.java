package net.kinginfotech.controller;

import lombok.extern.slf4j.Slf4j;
import net.kinginfotech.model.TodoData;
import net.kinginfotech.model.TodoItem;
import net.kinginfotech.service.TodoItemService;
import net.kinginfotech.util.AttributeNames;
import net.kinginfotech.util.Mappings;
import net.kinginfotech.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Slf4j
@Controller
public class TodoItemController {
    //==model attributes==
    private final TodoItemService todoItemService;

    //==constracture==
    @Autowired
    public  TodoItemController(TodoItemService todoItemService){
        this.todoItemService = todoItemService;
    }
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    //http:://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id, Model model){
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null){
            todoItem = new TodoItem("","", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    //==add data when form submited==
    @PostMapping(Mappings.ADD_ITEM)
    public  String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todo item from form = {}",todoItem);
        if(todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }
        return  "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public  String deleteItem(@RequestParam int  id){
        log.info("delete  item ");
        todoItemService.removeItem(id);
        return  "redirect:/" + Mappings.ITEMS;
    }


    @GetMapping(Mappings.VIEW_ITEM)
    public  String viewItem(@RequestParam int  id,Model model){
        log.info("view item");
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
