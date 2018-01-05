package camp.mage.server.game.objs;

import camp.mage.server.game.World;

/**
 * Created by jacob on 1/4/18.
 */

public class FlowerObject extends BaseObject {
    public FlowerObject(World world) {
        super(world);
    }

    @Override
    public String getType() {
        return "flower";
    }
}