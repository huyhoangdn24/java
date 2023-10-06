package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", orders=" + orders +
                ", product=" + product +
                '}';
    }
}
