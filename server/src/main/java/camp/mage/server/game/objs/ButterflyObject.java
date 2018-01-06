package camp.mage.server.game.objs;

import camp.mage.server.game.World;
import camp.mage.server.game.map.MapPos;

/**
 * Created by jacob on 1/1/18.
 */

public class ButterflyObject extends BaseObject {

    private MapPos velocity;

    public ButterflyObject(World world) {
        super(world);

        collides = true;
        velocity = new MapPos();
    }

    @Override
    public String getType() {
        return "butterfly";
    }

    @Override
    public void update() {
        super.update();

        if (Math.random() < 0.005) {
            velocity.x = (float) (.1f * (Math.random() - .5f));
            velocity.y = (float) (.1f * (Math.random() - .5f));
        }

        for (Player player : map.getObjs().all(pos, Player.class, 3f)) {
            if (player.pos.squareDistance(pos) < 1) {
                world.leave(this);
                return;
            }

            velocity.x = pos.x - player.pos.x;
            velocity.y = pos.y - player.pos.y;
            velocity.nor().mul(.1f);
            break;
        }

        for (ButterflyObject butterfly : map.getObjs().all(pos, ButterflyObject.class, .5f)) {
            if (butterfly == this) {
                continue;
            }

            velocity.x = pos.x - butterfly.pos.x;
            velocity.y = pos.y - butterfly.pos.y;
            velocity.nor().mul(.1f);
            break;
        }

        getMap().moveBy(this, velocity);
    }
}
