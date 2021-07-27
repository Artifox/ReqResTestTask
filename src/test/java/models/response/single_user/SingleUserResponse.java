package models.response.single_user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SingleUserResponse {
    public Data data;
    public Support support;
}
