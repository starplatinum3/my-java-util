package entity;

;

import lombok.Data;

@Data
public class ColeFragGameStat {
    Long id;
//    收集碎片游戏统计
//id
//        用户id
//    拼出的垃圾id
    Long userId;
    Long haveRubId;

}
