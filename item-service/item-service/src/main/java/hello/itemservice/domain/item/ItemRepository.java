package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static. 실제론 해쉬맵 쓰면 안돼
    private static long sequence = 0L ;//static 원래는 Long 사용x
    //동시에 접근했을 때 위 둘을 사용하면 값이 꼬일 수 있음

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;

    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }


}
