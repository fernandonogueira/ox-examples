package ox.samples.spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Accommodation {

    @Id
    private String id;

    private String description;

    private double[] location;

}
