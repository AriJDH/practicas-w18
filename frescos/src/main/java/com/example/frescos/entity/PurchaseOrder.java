package com.example.frescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderNumber;
    private LocalDate orderDate;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Buyer buyer;
    private String status;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "purchase_order_number")
    private List<Item> items;

    public Double totalPrice(){
        return items.stream().mapToDouble(item->item.getProduct().getPrice()*item.getQuantity()).sum();
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }
    public void removeAllItems(){
        this.items.removeAll(this.items);
    }
    public void addAllItems(List<Item> items){
        this.items.addAll(items);
    }
    public List<Product> getProducts(){
        List<Product> products =new ArrayList<>();
        for(Item item: this.items){
            products.add(item.getProduct());
        }
        return products;
    }
}