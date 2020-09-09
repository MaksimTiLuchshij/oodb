import java.util.Date;

public class Contract {
    private Date dateOfConclusion;
    private float amount;
    public Contract(Date dateOfConclusion, float amount){
        this.dateOfConclusion = dateOfConclusion;
        this.amount = amount;
    }

    public void setDateOfConclusion(Date dateOfConclusion){
        this.dateOfConclusion = dateOfConclusion;
    }
    public Date getDateOfConclusion(){
        return dateOfConclusion;
    }
    public void setAmount(float amount){
        this.amount = amount;
    }
    public float getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Date of conclusion='" + dateOfConclusion + '\'' +
                "amount='" + amount + '\'' +
                '}';
    }
}
