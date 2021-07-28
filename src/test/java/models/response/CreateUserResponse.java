package models.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateUserResponse {

    //@SerializedName("name")
    String userName;
    //@SerializedName("job")
    String jobTitle;
    String id;
    //@SerializedName("createdAt")
    String createdAt;
}
