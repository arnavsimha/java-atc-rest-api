package model.response;

public class AqmResponse {

    private String status;

    public AqmResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString(){
        return this.status;
    }
}
