package ox.samples.spring.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Booking {

    private String id;

    private Long userId;

    private Long accommodationId;

}
