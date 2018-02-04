package ox.samples.spring.ox.migrations;

import ox.engine.internal.OxAction;
import ox.engine.internal.OxEnvironment;
import ox.engine.structure.Migration;
import ox.engine.structure.OrderingType;

public class V0001__bookings_indexes implements Migration {

    @Override
    public void up(OxEnvironment oxEnvironment) {
        oxEnvironment.execute(OxAction
                .createIndex("user_id_accommodation_id_idx")
                .setCollection("booking")
                .addAttribute("userId", OrderingType.ASC)
                .addAttribute("accommodationId", OrderingType.ASC));

        oxEnvironment.execute(OxAction
                .createIndex("user_id_idx")
                .setCollection("booking")
                .addAttribute("userId", OrderingType.ASC));

        oxEnvironment.execute(OxAction
                .createIndex("accommodation_id_idx")
                .setCollection("booking")
                .addAttribute("accommodationId", OrderingType.ASC));
    }

    @Override
    public void down(OxEnvironment oxEnvironment) {

        oxEnvironment.execute(OxAction
                .removeIndex("user_id_accommodation_id_idx")
                .setCollection("booking")
                .ifExists());

        oxEnvironment.execute(OxAction
                .removeIndex("user_id_idx")
                .setCollection("booking")
                .ifExists());

        oxEnvironment.execute(OxAction
                .removeIndex("accommodation_id_idx")
                .setCollection("booking")
                .ifExists());

    }

}
