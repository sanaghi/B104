package az.lesson.spring.customerservice.entity;

import az.lesson.spring.customerservice.enums.Role;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//@NamedEntityGraph(
//        name = "Customer.address",
//        attributeNodes = {
//                @NamedAttributeNode(value = "billingAddresses", subgraph = "billingAddressesSubgraph")
//        },
//        subgraphs = {
//                @NamedSubgraph(name = "billingAddressesSubgraph", attributeNodes = {
//                        @NamedAttributeNode("address")
//                })
//        }
//)
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Email(message = "Zəhmət olmasa doğru email formatı daxil edin")
    @Size(min = 7,max = 40)
    @NotNull
    @Column(unique = true)
    private String email;

    @Min(15)
    @Max(200)
    private  Integer age;


//
//    @ValidFinCode
//    private  String finNomre;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personFinCode",referencedColumnName = "finCode")
    @Valid
    private  Person  person;

    @JsonManagedReference(value = "BILLING_ADDRESS")
    @JsonIgnore
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    @Where(clause = "address_type = 'BILLING' ")
    private List<CustomerAddress> billingAddresses ;
//
    @Where(clause = "address_type = 'SHIPPING' ")
    @JsonIgnore
    @JsonManagedReference("SHIPPING_ADDRESS")
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    private List<CustomerAddress> shippingAddresses;


    @NotNull(message = "Borc məbləği boş ola bilməz")
    @Min(value = 1,message = "1 AZN dən kiçik ödənişlər qəbul olunmur")
    @Max(value = 200, message = "maksimal ödəniş 200 AZN")
    private Double debt;

    @Transient
    private String name;


    public Customer() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        // email in our case
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
