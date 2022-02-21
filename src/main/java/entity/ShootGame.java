package entity;



import lombok.Data;


@Data
public class ShootGame {
    
    Long id;
    Long userId;
    Integer shootCnt;
    Integer goalCnt;
}
