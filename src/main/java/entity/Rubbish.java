package entity;



import lombok.Data;


@Data
public class Rubbish {
    
    Long id;
    String name;
    Long typeId;
    String imgUrl;
    Long cityId;

}
