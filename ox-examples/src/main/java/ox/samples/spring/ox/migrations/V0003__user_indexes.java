package ox.samples.spring.ox.migrations;

import ox.engine.internal.OxAction;
import ox.engine.internal.OxEnvironment;
import ox.engine.structure.Migration;
import ox.engine.structure.OrderingType;

public class V0003__user_indexes implements Migration {

    @Override
    public void up(OxEnvironment oxEnvironment) {
        oxEnvironment.execute(
                OxAction.createIndex("username_idx")
                        .setCollection("user")
                        .addAttribute("username", OrderingType.DESC)
                        .ifNotExists()
                        .recreateIfNotEquals());
    }

    @Override
    public void down(OxEnvironment oxEnvironment) {
        oxEnvironment.execute(
                OxAction.removeIndex("username_idx")
                        .setCollection("user")
                        .ifExists());
    }

}
