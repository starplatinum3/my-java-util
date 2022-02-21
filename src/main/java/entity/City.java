package entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class City implements  Cloneable{
    Long id;
    String name;
    String picRes;
    String describe;
    Integer fragFullNeed;

    public City() {
    }

    public City(Long id, String name, String picRes, String describe, Integer fragFullNeed) {
        this.id = id;
        this.name = name;
        this.picRes = picRes;
        this.describe = describe;
        this.fragFullNeed = fragFullNeed;
    }

    @Override
    public City clone()  {
        City city = null;
        try{
            city = (City)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return city;
//        return super.clone();
    }
}
