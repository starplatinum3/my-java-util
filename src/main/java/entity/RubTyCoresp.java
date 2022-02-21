package entity;



import lombok.Data;


@Data
public class RubTyCoresp {
    
    Long id;
//    垃圾类型对应表
//            id
//    垃圾id
//            垃圾类型id
//    城市id

    Long rubbishId;
    Long rubTypeId;
    Long cityId;
}
