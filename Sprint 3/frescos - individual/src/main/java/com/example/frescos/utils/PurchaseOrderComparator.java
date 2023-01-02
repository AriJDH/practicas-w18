package com.example.frescos.utils;

import com.example.frescos.entity.PurchaseOrder;

import java.util.Comparator;

public class PurchaseOrderComparator implements Comparator<PurchaseOrder> {
    @Override
    public int compare(PurchaseOrder p1, PurchaseOrder p2) {
        int first = p1.getOrderDate().compareTo(p2.getOrderDate());
        if(first==0)
            return -p1.getOrderNumber().compareTo(p2.getOrderNumber());
        return -first;
    }
}
