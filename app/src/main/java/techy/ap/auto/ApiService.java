package techy.ap.auto;

import retrofit2.Call;
import retrofit2.http.GET;
import techy.ap.auto.Modal.Employee;

public interface ApiService {
    @GET("retrofit/json_object.json")
    Call<EmployeeList>getMyJson();
}
