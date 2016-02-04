package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "Products")
//@Document(indexName="respond")
public class Products {
    //@Id
    //@Column(name = "ProductId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;
    private String sku;
    private String name;
    private BigDecimal price;
    private String shipping;
    private BigDecimal weight;
    private String download;
    private Timestamp created;

    public String getId() {
        return id;
    }

    public void setId(String productId) {
        this.id = productId;
    }

    //@Basic
    //@Column(name = "SKU", nullable = false, insertable = true, updatable = true, length = 50)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    //@Basic
    //@Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 512)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Basic
    //@Column(name = "Price", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //@Basic
    //@Column(name = "Shipping", nullable = false, insertable = true, updatable = true, length = 50)
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    //@Basic
    //@Column(name = "Weight", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    //@Basic
    //@Column(name = "Download", nullable = true, insertable = true, updatable = true, length = 512)
    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    //@Basic
    //@Column(name = "Created", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != null ? !id.equals(products.id) : products.id != null) return false;
        if (sku != null ? !sku.equals(products.sku) : products.sku != null) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (shipping != null ? !shipping.equals(products.shipping) : products.shipping != null) return false;
        if (weight != null ? !weight.equals(products.weight) : products.weight != null) return false;
        if (download != null ? !download.equals(products.download) : products.download != null) return false;
        if (created != null ? !created.equals(products.created) : products.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (shipping != null ? shipping.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (download != null ? download.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
