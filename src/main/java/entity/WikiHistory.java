package entity;



import java.util.Date;

import lombok.Data;


@Data
public class WikiHistory {
    
    Long id;
    String content ;
    Long userId;
//    Date time;
    Long time;
}
