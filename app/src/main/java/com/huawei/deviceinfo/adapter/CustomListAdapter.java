package com.huawei.deviceinfo.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.an.deviceinfo.device.model.Memory;
import com.an.deviceinfo.device.model.Network;
import com.an.deviceinfo.usercontacts.UserContacts;
import com.huawei.deviceinfo.Bean.Ad;
import com.huawei.deviceinfo.Bean.App;
import com.huawei.deviceinfo.Bean.Battery;
import com.huawei.deviceinfo.Bean.Device;
import com.huawei.deviceinfo.Bean.DeviceLocation;
import com.huawei.deviceinfo.Bean.UserApps;
import com.huawei.deviceinfo.R;

import java.util.List;


public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.CustomViewHolder> {

    private Context context;
    private List deviceList;
    private Object object;

    public CustomListAdapter(Context context, List deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }



    public CustomListAdapter(Context context, Object object) {
        this.context = context;
        this.object = object;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_list_item, null);
        CustomListAdapter.CustomViewHolder viewHolder = new CustomListAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        if(deviceList == null) {
            if(object instanceof Ad) {
                handleAdInfo(holder, position);
            } else if(object instanceof DeviceLocation) {
                handleLocationInfo(holder, position);
            }  else if(object instanceof App) {
                handleAppInfo(holder, position);
            }  else if(object instanceof Battery) {
                handleBatteryInfo(holder, position);
            }   else if(object instanceof Memory) {
                handleMemoryInfo(holder, position);
            }   else if(object instanceof Network) {
                handleNetworkInfo(holder, position);
            }   else if(object instanceof Device) {
                handleDeviceInfo(holder, position);
            }
            return;
        }

        Object object = deviceList.get(position);
        if(object instanceof UserApps) {
            holder.textView.setText(((UserApps) object).getAppName());
            holder.desc.setText(((UserApps) object).getPackageName());
        } else {
            holder.textView.setText(((UserContacts) object).getDisplayName());
            holder.desc.setText(((UserContacts) object).getMobileNumber());
        }
    }

    @Override
    public int getItemCount() {
        if(deviceList == null) return object.getClass().getDeclaredFields().length;
        return deviceList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView desc;
        public CustomViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.desc = (TextView) itemView.findViewById(R.id.textDesc);
            textView.setFocusable(true);
        }
    }



    private void handleAdInfo(CustomViewHolder holder, int position) {
        if(position == 0) {
            holder.textView.setText(R.string.advertisingId);
            holder.desc.setText(((Ad) object).getAdvertisingId());
        } else {
            holder.textView.setText(R.string.allow_to_track_ads);
            holder.desc.setText(String.valueOf(((Ad) object).isAdDoNotTrack()));
        }
    }

    private void handleLocationInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.lattitude);
                     holder.desc.setText(String.valueOf(((DeviceLocation) object).getLatitude()));
                break;
            case 1: holder.textView.setText(R.string.longitude);
                    holder.desc.setText(String.valueOf(((DeviceLocation) object).getLongitude()));
                break;
            case 2: holder.textView.setText(R.string.address_line_one);
                    holder.desc.setText(((DeviceLocation) object).getAddressLine1());
                break;
            case 3: holder.textView.setText(R.string.city);
                    holder.desc.setText(((DeviceLocation) object).getCity());
                break;
            case 4: holder.textView.setText(R.string.state);
                    holder.desc.setText(((DeviceLocation) object).getState());
                break;
            case 5: holder.textView.setText(R.string.country_code);
                    holder.desc.setText(((DeviceLocation) object).getCountryCode());
                break;
            case 6: holder.textView.setText(R.string.postal_code);
                    holder.desc.setText(((DeviceLocation) object).getPostalCode());
                break;
        }
    }

    private void handleAppInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.app_name);
                     holder.desc.setText(((App) object).getAppName());
                break;
            case 1: holder.textView.setText(R.string.package_name);
                    holder.desc.setText(((App) object).getPackageName());
                break;
            case 2: holder.textView.setText(R.string.activity_name);
                    holder.desc.setText(((App) object).getActivityName());
                break;
            case 3: holder.textView.setText(R.string.app_version_name);
                    holder.desc.setText(((App) object).getAppVersionName());
                break;
            case 4: holder.textView.setText(R.string.app_version_code);
                    holder.desc.setText(String.valueOf(((App) object).getAppVersionCode()));
                break;
        }
    }

    private void handleBatteryInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.battery_percent);
                     holder.desc.setText(String.valueOf(((Battery) object).getBatteryPercent()));
                break;
            case 1: holder.textView.setText(R.string.Is_phone_charging);
                    holder.desc.setText(String.valueOf(((Battery) object).isPhoneCharging()));
                break;
            case 2: holder.textView.setText(R.string.battery_health);
                    holder.desc.setText(((Battery) object).getBatteryHealth());
                break;
            case 3: holder.textView.setText(R.string.battery_technology);
                    holder.desc.setText(((Battery) object).getBatteryTechnology());
                break;
            case 4: holder.textView.setText(R.string.battery_temperature);
                    holder.desc.setText(String.valueOf(((Battery) object).getBatteryTemperature()));
                break;
            case 5: holder.textView.setText(R.string.battery_voltage);
                    holder.desc.setText(String.valueOf(((Battery) object).getBatteryVoltage()));
                break;
            case 6: holder.textView.setText(R.string.charging_source);
                holder.desc.setText(((Battery) object).getChargingSource());
                break;
            case 7: holder.textView.setText(R.string.Is_battery_present);
                holder.desc.setText(String.valueOf(((Battery) object).isBatteryPresent()));
                break;
        }
    }

    private void handleMemoryInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.has_sdcard);
                     holder.desc.setText(String.valueOf(((Memory) object).isHasExternalSDCard()));
                break;
            case 1: holder.textView.setText(R.string.total_ram);
                    holder.desc.setText(String.valueOf(convertToGb(((Memory) object).getTotalRAM())) + " GB");
                break;
            case 2: holder.textView.setText(R.string.total_internal_menory);
                    holder.desc.setText(String.valueOf(convertToGb(((Memory) object).getTotalInternalMemorySize()))  + " GB");
                break;
            case 3: holder.textView.setText(R.string.available_memory);
                    holder.desc.setText(String.valueOf(convertToGb(((Memory) object).getAvailableInternalMemorySize()))  + " GB");
                break;
            case 4: holder.textView.setText(R.string.total_external_memory);
                    holder.desc.setText(String.valueOf(convertToGb( ((Memory) object).getTotalExternalMemorySize()) ) + " GB");
                break;
            case 5: holder.textView.setText(R.string.available_external_momory);
                    holder.desc.setText(String.valueOf(convertToGb (((Memory) object).getAvailableExternalMemorySize()) ) + " GB");
                break;
        }
    }

    private void handleNetworkInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.imei);
                     holder.desc.setText(((Network) object).getIMEI());
                break;
            case 1: holder.textView.setText(R.string.imsi);
                    holder.desc.setText(((Network) object).getIMSI());
                break;
            case 2: holder.textView.setText(R.string.phone_type);
                    holder.desc.setText(((Network) object).getPhoneType());
                break;
            case 3: holder.textView.setText(R.string.phone_num);
                    holder.desc.setText(((Network) object).getPhoneNumber());
                break;
            case 4: holder.textView.setText(R.string.carrier);
                    holder.desc.setText(((Network) object).getOperator());
                break;
            case 5: holder.textView.setText(R.string.sim_serial);
                    holder.desc.setText(((Network) object).getsIMSerial());
                break;
            case 6: holder.textView.setText(R.string.is_sim_locked);
                    holder.desc.setText(String.valueOf(((Network) object).isSimNetworkLocked()));
                break;
            case 7: holder.textView.setText(R.string.is_nfc_enabled);
                    holder.desc.setText(String.valueOf(((Network) object).isNfcEnabled()));
                break;
            case 8: holder.textView.setText(R.string.is_nfc_present);
                    holder.desc.setText(String.valueOf(((Network) object).isNfcPresent()));
                break;
            case 9: holder.textView.setText(R.string.is_wifi_enabled);
                    holder.desc.setText(String.valueOf(((Network) object).isWifiEnabled()));
                break;
            case 10: holder.textView.setText(R.string.is_network_vailable);
                     holder.desc.setText(String.valueOf(((Network) object).isNetworkAvailable()));
                break;
            case 11: holder.textView.setText(R.string.network_class);
                     holder.desc.setText(((Network) object).getNetworkClass());
                break;
            case 12: holder.textView.setText(R.string.network_type);
                     holder.desc.setText(((Network) object).getNetworkType());
                break;
        }
    }


    private void handleDeviceInfo(CustomViewHolder holder, int position) {
        switch (position) {
            case 0:  holder.textView.setText(R.string.manufacturer);
                     holder.desc.setText(((Device) object).getManufacturer());
                break;
            case 1: holder.textView.setText(R.string.model);
                    holder.desc.setText(((Device) object).getModel());
                break;
            case 2: holder.textView.setText(R.string.build_versioncode_ame);
                    holder.desc.setText(((Device) object).getBuildVersionCodeName());
                break;
            case 3: holder.textView.setText(R.string.release_build_ersion);
                    holder.desc.setText(((Device) object).getReleaseBuildVersion());
                break;
            case 4: holder.textView.setText(R.string.product);
                    holder.desc.setText(((Device) object).getProduct());
                break;
            case 5: holder.textView.setText(R.string.fingerprint);
                    holder.desc.setText(((Device) object).getFingerprint());
                break;
            case 6: holder.textView.setText(R.string.hardware);
                    holder.desc.setText(((Device) object).getHardware());
                break;
            case 7: holder.textView.setText(R.string.radio_Version);
                    holder.desc.setText(((Device) object).getRadioVersion());
                break;
            case 8: holder.textView.setText(R.string.device);
                    holder.desc.setText(((Device) object).getDevice());
                break;
            case 9: holder.textView.setText(R.string.board);
                    holder.desc.setText(((Device) object).getBoard());
                break;
            case 10: holder.textView.setText(R.string.display_version);
                     holder.desc.setText(((Device) object).getDisplayVersion());
                break;
            case 11: holder.textView.setText(R.string.build_brand);
                     holder.desc.setText(((Device) object).getBuildBrand());
                break;
            case 12: holder.textView.setText(R.string.build_host);
                     holder.desc.setText(((Device) object).getBuildHost());
                break;
            case 13: holder.textView.setText(R.string.build_time);
                     holder.desc.setText(String.valueOf(((Device) object).getBuildTime()));
                break;
            case 14: holder.textView.setText(R.string.build_user);
                     holder.desc.setText(((Device) object).getBuildUser());
                break;
            case 15: holder.textView.setText(R.string.serial);
                     holder.desc.setText(((Device) object).getSerial());
                break;
            case 16: holder.textView.setText(R.string.os_version);
                     holder.desc.setText(((Device) object).getOsVersion());
                break;
            case 17: holder.textView.setText(R.string.language);
                     holder.desc.setText(((Device) object).getLanguage());
                break;
            case 18: holder.textView.setText(R.string.sdk_version);
                     holder.desc.setText(String.valueOf(((Device) object).getSdkVersion()));
                break;
            case 19: holder.textView.setText(R.string.screen_density);
                     holder.desc.setText(((Device) object).getScreenDensity());
                break;
            case 20: holder.textView.setText(R.string.screen_height);
                     holder.desc.setText(String.valueOf(((Device) object).getScreenHeight()));
                break;
            case 21: holder.textView.setText(R.string.screen_width);
                     holder.desc.setText(String.valueOf(((Device) object).getScreenWidth()));
                break;
        }
    }


    private float convertToGb(long valInBytes) {
        return Float.valueOf(String.format("%.2f", (float) valInBytes / (1024 * 1024 * 1024)));
    }
}
