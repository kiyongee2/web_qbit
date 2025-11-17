package com.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "member")
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password; 
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String role;
}

