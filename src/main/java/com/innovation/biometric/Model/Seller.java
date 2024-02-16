package com.innovation.biometric.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seller", schema = "default")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;


    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;


    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany
    private List<SellerComment> sellerComment;

    public Seller(String name, String profilePictureUrl, String phoneNumber, Date createDate) {
        this.name = name;
        this.profilePictureUrl = profilePictureUrl;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
    }
}
