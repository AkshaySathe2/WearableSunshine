package com.udacity.akki.sunshine.wear;

import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;
import com.udacity.akki.sunshine.sync.SunshineSyncAdapter;
import com.udacity.akki.sunshine.sync.SunshineSyncUtils;

/**
 * Created by 836158 on 24-01-2017.
 */

public class WearableWeatherService extends WearableListenerService {

    private static final String TAG = WearableWeatherService.class.getSimpleName();

    private static final String WEATHER_PATH = "/weather";

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                String path = dataEvent.getDataItem().getUri().getPath();
                Log.d(TAG, path);
                if (path.equals(WEATHER_PATH)) {
                    SunshineSyncUtils.startImmediateSync(this);
                }
            }
        }
    }

}
