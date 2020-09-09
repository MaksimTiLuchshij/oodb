import java.util.List;

public class EstateAgency{
    private String name;
    public EstateAgency(String name) {
        this.name = name;
    }

    private List<Realtor> realtors;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public List<Realtor> getRealtors() {
        return realtors;
    }

    public void setRealtors(List<Realtor> realtors) {
        this.realtors = realtors;
    }

    @Override
    public String toString() {
        return "Estate agency: " + getName() +
                ", realtors=" + realtors +
                '\n';
    }
}