package com.omdeep.myretrofit.UserPojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.R;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {
    private List<UsersResponse> usersResponseList;
    private Context context;

    public UserRecyclerAdapter(List<UsersResponse> usersResponseList, Context context) {
        this.usersResponseList = usersResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_display, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.ViewHolder holder, int position) {
        UsersResponse userData = usersResponseList.get(position);
             holder.Id.setText(String.valueOf(userData.getId()));
             holder.name.setText(userData.getName());
             holder.username.setText(userData.getUsername());
             holder.email.setText(userData.getEmail());
             holder.street.setText(userData.getAddress().getStreet());
             holder.suite.setText(userData.getAddress().getSuite());
             holder.city.setText(userData.getAddress().getCity());
             holder.zipcode.setText(userData.getAddress().getZipcode());
             holder.lat.setText(userData.getAddress().getGeoUserResponse().getLat());
             holder.lng.setText(userData.getAddress().getGeoUserResponse().getLng());
             holder.phone.setText(userData.getPhone());
             holder.website.setText(userData.getWebsite());
             holder.companyName.setText(userData.getCompany().getName());
             holder.catchPhrase.setText(userData.getCompany().getCatchPhrase());
             holder.bs.setText(userData.getCompany().getBs());
    }

    @Override
    public int getItemCount() {
        return usersResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Id, name, username, email, address, street, suite, city, zipcode, geo, lat, lng, phone, website, company, companyName, catchPhrase, bs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Id = itemView.findViewById(R.id.id3);
            name = itemView.findViewById(R.id.name1);
            username = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);
            street = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipCode);
            geo = itemView.findViewById(R.id.geo);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            company = itemView.findViewById(R.id.company);
            companyName = itemView.findViewById(R.id.companyName);
            catchPhrase = itemView.findViewById(R.id.catchPhrase);
            bs = itemView.findViewById(R.id.bs);
        }
    }
}
