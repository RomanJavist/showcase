package com.test.appliances.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Showcase")
public class Showcase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "sc_items")
    private List<Item> items;
    @Column(name = "name")
    @NotEmpty(message = "Cannot be empty")
    private String name;
    @Column(name = "address")
    @NotEmpty(message = "Cannot be empty")
    private String address;
    @Column(name = "type")
    private ShowcaseType type;
    @Column(name = "date_create")
    private Date date_create;
    @Column(name = "date_edit")
    private Date date_edit;

    private LocalDateTime dateTimeOfCreated;
    private void init(){
        dateTimeOfCreated = LocalDateTime.now();
    }

    private Date lastUpdateAt;

    @PrePersist
    public void recordUpdateTime(){
        lastUpdateAt = new Date();
    }

    public LocalDateTime getDateTimeOfCreated() {
        return dateTimeOfCreated;
    }

    public void setDateTimeOfCreated(LocalDateTime dateTimeOfCreated) {
        this.dateTimeOfCreated = dateTimeOfCreated;
    }
}
