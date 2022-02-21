package entity;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
//@AllArgsConstructor
public class RubbishType {
    
    Long id;
    String name;
    //垃圾类型的名字
    String describe;
    //描述
    String throwRequirement;
    //投放要求
    String imgUrl;
    //图标id
    public RubbishType() {
    }

    public RubbishType(Long id, String name, String describe, String throwRequirement, String imgUrl) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.throwRequirement = throwRequirement;
        this.imgUrl = imgUrl;
    }
    //    id
//            名字
//    描述
//            投放要求
//    图标id


}
