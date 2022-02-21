package entity;



import lombok.Data;


@Data
public class Present {
    
    Long id;
    String name;
    String describe;
    Double price;
    Integer imgRes;
    Integer needPoint;

}
