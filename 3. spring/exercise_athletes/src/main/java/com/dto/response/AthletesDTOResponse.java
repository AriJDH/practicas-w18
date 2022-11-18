package com.dto.response;

import com.entity.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AthletesDTOResponse {
  private String name;
  private List<String> sports;
}
