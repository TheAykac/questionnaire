package org.example.questionnaire.model.abstracts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.questionnaire.model.User;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class BaseAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

