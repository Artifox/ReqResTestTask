package models.response.get_single_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetSingleUserResponse {
    public Data data;
    public Support support;
}
