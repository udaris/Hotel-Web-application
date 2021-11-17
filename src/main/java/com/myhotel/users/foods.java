package com.myhotel.users;

import javax.persistence.*;

@Entity
@Table(name = "foods")
public class foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private  String recepiName;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String prize;

}
