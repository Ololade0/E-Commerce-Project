package africa.semicolon.lumexpress.data.dto.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemstRequest {
    private int numberOfItemsProductsPerPage;
    private int pageNumber;

}
