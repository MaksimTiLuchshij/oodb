import java.util.Date;
import java.util.List;

public class Realtor extends Person {

    private float amount_of_commission;

    private List<Client> clients;
    private List<Apartments> apartments;
    private List<Contract> contracts;

    public Realtor(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Realtor() {
    }

    public void setAmount_of_commission(float amount_of_commission){
        this.amount_of_commission = amount_of_commission;
    }

    public float getAmount_of_commission(){
        return amount_of_commission;
    }

    public void addContract(Apartments apartment, Client client, float endPrice){
        endPrice = apartment.getPrice() + amount_of_commission*apartment.getPrice()/100;
        Contract contract = new Contract(new Date(),endPrice);
        contracts.add(contract);
        apartments.remove(apartment);
    }
    @Override
    public String toString() {
        return "Realtor{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", amount of commission='" + getAmount_of_commission() + '\'' +
                '}';
    }
}
