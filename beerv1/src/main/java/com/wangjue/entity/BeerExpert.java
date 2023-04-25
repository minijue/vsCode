package com.wangjue.entity;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
  public List<String> getBrands(String color) {
    List<String> brands = new ArrayList<>();
    if (color.equals("brown")) {
      brands.add("Jail Pale Ale");
      brands.add("Gout Stout");
    } else {
      brands.add("Jack Amber");
      brands.add("Red Moose");
    }
    return brands;
  }
}
