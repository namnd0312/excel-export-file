package com.namnd.exportexcel.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 28/02/2021 - 6:45 PM
 */

@Getter
@Setter
@Entity
@Data
@Table(name = "user_1")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "sex", length = 50, nullable = false)
    private String sex;

    @Column(name = "age", length = 50, nullable = false)
    private String age;
}
