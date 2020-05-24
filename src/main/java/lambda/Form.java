package lambda;


public class Form {

    public Form(){}

    public Form(String type){
        this.type = type;
    }

    public Form(Long id, String type){
        this.id = id;
        this.type = type;
    }

    private Long id;
    private String type;
}
