package com.crypto.exchange.authentication.model;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verification_token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "token")
    private String token;

    @Column(name = "expiryDate")
    private Instant expiryDate;

    @Column(name = "createdDate")
    private Instant createdDate;

}
