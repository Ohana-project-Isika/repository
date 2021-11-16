package fr.isika.cda11.ohana.project.common.models;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Base64;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

//    @NotNull(message = "L'identifiant doit être renseigné")
//    @NotBlank(message = "L'identifiant ne doit pas être vide")
    private String username;

//    @NotNull(message = "Le mot de passe doit être renseigné")
//    @NotBlank(message = "Le mot de passe ne doit pas être vide")
    @Transient
    @Setter(AccessLevel.NONE)
    private byte[] encodedPassword;

    private String password;

    public void setPassword(String password) {
        this.encodedPassword = Base64.getDecoder().decode(password.getBytes());
    }
}
