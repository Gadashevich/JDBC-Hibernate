package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name= "user")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     @Column
     String name;
     @Column
     String lastName;
     @Column
     Byte age;

     public User(String name, String lastName, Byte age) {
          this.name = name;
          this.lastName = lastName;
          this.age = age;
     }
}
