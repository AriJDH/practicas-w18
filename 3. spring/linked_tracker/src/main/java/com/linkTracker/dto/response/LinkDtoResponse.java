package com.linkTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDtoResponse {
  private Long id;
  private String url;
  private Integer redirectCount;
  private boolean isValid;
}
