package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class ProductsDto {
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

    @JsonProperty("SKU")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("Shipping")
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("Weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @JsonProperty("Download")
    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    @JsonProperty("Created")
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

        ProductsDto products = (ProductsDto) o;

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
