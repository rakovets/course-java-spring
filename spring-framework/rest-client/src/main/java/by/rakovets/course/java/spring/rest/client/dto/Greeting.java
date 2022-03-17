package by.rakovets.course.java.spring.rest.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Greeting {
    private Integer id;
    private String content;
}
