package shop.shoppingmall.status;

public enum ProductStatus {

    ACTIVE("활성화"), INACTIVE("비활성화"), PENDING("보류중");

    private String value;

    ProductStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
