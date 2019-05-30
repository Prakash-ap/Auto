package techy.ap.auto;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techy.ap.auto.Adapter.RecyclerAdapterActivity;
import techy.ap.auto.Modal.Employee;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapterActivity recyclerAdapterActivity;
    private List<Employee> employeeList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiService apiService=RetrofitClient.getApiService();

        Call<EmployeeList> call=apiService.getMyJson();

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    employeeList=response.body().getEmployee();
                    recyclerAdapterActivity=new RecyclerAdapterActivity(employeeList);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(recyclerAdapterActivity);

                }
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}
