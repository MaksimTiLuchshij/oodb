public class Apartments {
    private String address;
    private String Owner;
    private float price;

    public Apartments(String address, float price){
        this.address = address;
        this.price = price;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public String getAddress(){
        return address;
    }
    public float getPrice(){
        return price;
    }
}
