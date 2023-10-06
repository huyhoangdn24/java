package mvc.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "customer_name")
    private String customerName;
    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetailsEntity;


    public OrdersEntity() {

    }

    public List<OrderDetailsEntity> getOrderDetailsEntity() {
        return orderDetailsEntity;
    }

    public void setOrderDetailsEntity(List<OrderDetailsEntity> orderDetailsEntity) {
        this.orderDetailsEntity = orderDetailsEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {

        return "OrdersEntity{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
