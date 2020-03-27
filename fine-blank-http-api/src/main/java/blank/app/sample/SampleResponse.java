package blank.app.sample;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fineframework.net.http.FineStandardResponseBase;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SampleResponse extends FineStandardResponseBase {

}
