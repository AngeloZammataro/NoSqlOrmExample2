package it2.develhope.NoSqlOrmExample.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String email;

    private List<Order> orders;

}
