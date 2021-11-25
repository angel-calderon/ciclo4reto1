package com.sergioarboleda.divinacomedia.app.model;
/**
 * @uthor Angel Calderon
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    @Column(name = "user_name", length = 80, nullable = false)
    private String name;

}

