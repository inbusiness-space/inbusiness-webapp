package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class TransactionsDto {
    private String id;
    private String processor;
    private String processorTransactionId;
    private String processorStatus;
    private String email;
    private String payerId;
    private String name;
    private BigDecimal shipping;
    private BigDecimal fee;
    private BigDecimal tax;
    private BigDecimal total;
    private String currency;
    private String items;
    private String data;
    private String receipt;
    private Timestamp created;

    public String getId() {
        return id;
    }

    public void setId(String transactionId) {
        this.id = transactionId;
    }

    @JsonProperty("Processor")
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @JsonProperty("ProcessorTransactionId")
    public String getProcessorTransactionId() {
        return processorTransactionId;
    }

    public void setProcessorTransactionId(String processorTransactionId) {
        this.processorTransactionId = processorTransactionId;
    }

    @JsonProperty("ProcessorStatus")
    public String getProcessorStatus() {
        return processorStatus;
    }

    public void setProcessorStatus(String processorStatus) {
        this.processorStatus = processorStatus;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("PayerId")
    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Shipping")
    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("Fee")
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @JsonProperty("Tax")
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @JsonProperty("Total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("Items")
    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @JsonProperty("Data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("Receipt")
    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
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

        TransactionsDto that = (TransactionsDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (processor != null ? !processor.equals(that.processor) : that.processor != null) return false;
        if (processorTransactionId != null ? !processorTransactionId.equals(that.processorTransactionId) : that.processorTransactionId != null) return false;
        if (processorStatus != null ? !processorStatus.equals(that.processorStatus) : that.processorStatus != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (payerId != null ? !payerId.equals(that.payerId) : that.payerId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shipping != null ? !shipping.equals(that.shipping) : that.shipping != null) return false;
        if (fee != null ? !fee.equals(that.fee) : that.fee != null) return false;
        if (tax != null ? !tax.equals(that.tax) : that.tax != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (receipt != null ? !receipt.equals(that.receipt) : that.receipt != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (processor != null ? processor.hashCode() : 0);
        result = 31 * result + (processorTransactionId != null ? processorTransactionId.hashCode() : 0);
        result = 31 * result + (processorStatus != null ? processorStatus.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (payerId != null ? payerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shipping != null ? shipping.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (receipt != null ? receipt.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
