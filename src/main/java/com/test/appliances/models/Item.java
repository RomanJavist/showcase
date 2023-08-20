package com.test.appliances.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "showcase_id", referencedColumnName = "id")
    private Showcase sc_items;
    @Column(name = "position")
    private int position;
    @Column(name = "name")
    @NotEmpty(message = "Cannot be empty")
    private String name;
    @Column(name = "type")
    private ItemType type;
    @Column(name = "price")
    @NotEmpty(message = "Cannot be empty")
    private double price;
    @Column(name = "date_create")
    private Date date_create;
    @Column(name = "date_edit")
    private Date date_edit;
}
