package com.exacon.frigorifero.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "postit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostIt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "title")
    private String title;

    @Column(name = "timestamp")
    @UpdateTimestamp
    private LocalDateTime timestamp;
}
