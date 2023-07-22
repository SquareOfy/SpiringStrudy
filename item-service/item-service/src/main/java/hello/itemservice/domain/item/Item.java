package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//@Data 는 확인해보고 쓰기(주의) 내용 보고 알고 쓰기
@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
