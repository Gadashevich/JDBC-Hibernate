package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;

    public User() {
    }


}
