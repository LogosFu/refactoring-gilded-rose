package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {

  private String name;
  private int sellIn;
  private int quality;
}
