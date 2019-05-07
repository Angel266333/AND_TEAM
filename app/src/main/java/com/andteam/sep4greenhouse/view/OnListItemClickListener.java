package com.andteam.sep4greenhouse.view;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

public interface OnListItemClickListener {

    //TODO : Use actual DTO object
    void onListItemEditClick(TestResponse plantDTO);
    void onListItemDeleteCLick(TestResponse plantDTO);

}
