package ox.samples.spring.ox.migrations;

import ox.engine.internal.OxAction;
import ox.engine.internal.OxEnvironment;
import ox.engine.structure.Migration;
import ox.engine.structure.OrderingType;

public class V0002__accommodation_indexes implements Migration {

    @Override
    public void up(OxEnvironment oxEnvironment) {


        oxEnvironment
                .execute(OxAction.createIndex("description_idx")
                        .setCollection("accommodation")
                        .addAttribute("description", OrderingType.ASC)
                        .ifNotExists()
                        .recreateIfNotEquals());

        oxEnvironment
                .execute(OxAction.createIndex("location_idx")
                        .setCollection("accommodation")
                        .addAttribute("location", OrderingType.GEO_2DSPHERE)
                        .ifNotExists()
                        .recreateIfNotEquals());

    }

    @Override
    public void down(OxEnvironment oxEnvironment) {
        oxEnvironment
                .execute(OxAction.removeIndex("description_idx")
                        .setCollection("accommodation"));

        oxEnvironment
                .execute(OxAction.removeIndex("location_idx")
                        .setCollection("accommodation"));
    }
}
