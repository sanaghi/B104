package az.lesson.spring.customerservice.entity;

import az.lesson.spring.customerservice.validation.ValidFinCode;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Email(message = "Zəhmət olmasa doğru email formatı daxil edin")
    @Size(min = 7,max = 40)
    @NotNull
    private String emailAddress;

    @Min(15)
    @Max(200)
    private  Integer age;


//
//    @ValidFinCode
//    private  String finNomre;

    @NotNull
    private  String passwordHash;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personFinCode",referencedColumnName = "finCode")
    @Valid
    private  Person  person;

//    @JsonManagedReference(value = "BILLING_ADDRESS")
//    @JsonIgnore
//    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    @Fetch(FetchMode.JOIN)
//    @Where(clause = "address_type = 'BILLING' ")
//    private List<CustomerAddress> billingAddresses ;
//
//    @Where(clause = "address_type = 'SHIPPING' ")
//    @JsonIgnore
//    @JsonManagedReference("SHIPPING_ADDRESS")
//    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    @Fetch(FetchMode.JOIN)
//    private List<CustomerAddress> shippingAddresses;


    @NotNull(message = "Borc məbləği boş ola bilməz")
    @Min(value = 1,message = "1 AZN dən kiçik ödənişlər qəbul olunmur")
    @Max(value = 200, message = "maksimal ödəniş 200 AZN")
    private Double debt;

    @Transient
    private String name;


    public Customer() {
    }
}
