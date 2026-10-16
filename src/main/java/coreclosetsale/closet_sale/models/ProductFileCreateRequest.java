package coreclosetsale.closet_sale.models;

public class ProductFileCreateRequest {
    private String url;
    private int fileOrder;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getFileOrder() {
        return fileOrder;
    }
    public void setFileOrder(int fileOrder) {
        this.fileOrder = fileOrder;
    }

    
}
