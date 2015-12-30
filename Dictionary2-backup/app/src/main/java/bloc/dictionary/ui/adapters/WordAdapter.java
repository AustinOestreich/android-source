package bloc.dictionary.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Austin on 12/19/2015.
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordAdapterViewHolder>{
    @Override
    public WordAdapter.WordAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WordAdapter.WordAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WordAdapterViewHolder extends RecyclerView.ViewHolder{

        public WordAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
