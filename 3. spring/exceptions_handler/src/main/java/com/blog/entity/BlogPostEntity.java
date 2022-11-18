package com.blog.entity;

import java.util.Date;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPostEntity {
  private Long id;
  private String title;
  private String name;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
}
