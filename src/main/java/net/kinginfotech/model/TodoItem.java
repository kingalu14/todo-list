package net.kinginfotech.model;

import lombok.*;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    private String title;
    private String details;
    private LocalDate deadline;
    private int id;

    public TodoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadline = deadLine;
    }
}
