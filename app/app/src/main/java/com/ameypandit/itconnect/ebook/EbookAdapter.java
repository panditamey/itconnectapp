package com.ameypandit.itconnect.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ameypandit.itconnect.R;

import org.w3c.dom.Text;

import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    private Context context;
    private List<EbookData> list;

    public EbookAdapter(Context context,List<EbookData> list) {

        this.context = context;
        this.list = list;

    }



    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);

        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, final int position) {
            holder.ebookName.setText(String.valueOf(list.get(position).getName()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(context, String.valueOf(list.get(position).getName()), Toast.LENGTH_SHORT).show();
                }
            });

            holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Downloaded", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName ;
        private ImageView ebookDownload;



        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookName = itemView.findViewById(R.id.ebook_name);
            ebookDownload = itemView.findViewById(R.id.ebook_download);

        }
    }
}
