package techy.ap.auto.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import techy.ap.auto.Modal.Employee;
import techy.ap.auto.R;

public class RecyclerAdapterActivity extends RecyclerView.Adapter<RecyclerAdapterActivity.MyViewHolder> {

    private List<Employee>employeeList;

    public RecyclerAdapterActivity( List<Employee> employeeList) {

        this.employeeList = employeeList;
    }


    @NonNull
    @Override
    public RecyclerAdapterActivity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_layout,viewGroup,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterActivity.MyViewHolder myViewHolder, int i) {
        Employee employee=employeeList.get(i);
        myViewHolder.name.setText(employee.getName());
        myViewHolder.dob.setText(employee.getDob());


    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,dob;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            dob=itemView.findViewById(R.id.dob);
        }
    }
}
