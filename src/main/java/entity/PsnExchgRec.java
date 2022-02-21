package entity;



import java.util.Date;

import lombok.Data;


@Data
public class PsnExchgRec {
//    礼品的兑换记录
//            id
//    用户id
//            礼品id
//    time

    
    Long id;
    String userId;
    String presentId;
//    Date time;
    Long time;

}
