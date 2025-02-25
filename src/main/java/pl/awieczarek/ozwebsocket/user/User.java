package pl.awieczarek.ozwebsocket.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
class User {
    @Id
    private String index;
    private String fullName;
    private Status status;
}
