package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public double total = 0;

    public boolean addItem(Item item) {
        total += item.getProduct().getPrice() * item.getQuantity();
        return items.add(item);
    }

//    public boolean removeItem(Item item) {
//        for(Item i:items){
//            if(i.getProductName() == item.getProductName()){
//                items.remove(i);
//                return true;
//            }
//        }
//        return true;
//    }

    public boolean removeItem(String name) {
        for(Item i:items){
//            System.out.println("." + i.getProductName() + "." + name + ".");
//            System.out.println(i.getProductName().equals(name));
            if(i.getProductName().equals(name)){
                total = total - i.getProduct().getPrice() * i.getQuantity();
                items.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean deleteItem(String productId, int amount) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getProduct().getId().equals(productId)) {
                if (item.getQuantity() > amount) {
                    total = total - item.getProduct().getPrice() * amount;
                    item.setQuantity(item.getQuantity() - amount);
                } else {
                    items.remove(item);
                }
                return true;
            }
        }
        return false;
    }

    public void test(){

    }

    @Override
    public String toString() {
        if (items.size() ==0){
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n"  );

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n"  );

        stringBuilder.append("Total...\t\t\t" + total );

        return stringBuilder.toString();
    }
}
