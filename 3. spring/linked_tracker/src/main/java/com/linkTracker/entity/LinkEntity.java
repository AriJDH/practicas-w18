package com.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkEntity {
  private Long id;
  private String url;
  private Integer redirectCount;
  private boolean isValid;
}
