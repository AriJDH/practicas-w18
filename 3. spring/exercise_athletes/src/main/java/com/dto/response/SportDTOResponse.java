package com.dto.response;

import com.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SportDTOResponse {
  private String name;
  private String level;
}
