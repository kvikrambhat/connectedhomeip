/*
 *   Copyright (c) 2020 Project CHIP Authors
 *   All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.google.chip.chiptool;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CHIPToolActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.top_activity);
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.top_frame, new CHIPFragment(this))
        .commit();
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }
  }

  public static class CHIPFragment extends Fragment {
    CHIPToolActivity activity;

    CHIPFragment(CHIPToolActivity activity) {
      this.activity = activity;
    }

    @Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(R.xml.root_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      Button button = (Button) view.findViewById(R.id.scan_qr_button);
      button.setOnClickListener(
          new View.OnClickListener() {
            public void onClick(View v) {
              Intent intent = new Intent(activity, BarcodeReaderActivity.class);
              startActivityForResult(intent, BarcodeReaderActivity.BARCODE_READER_ACTIVITY_REQUEST);
            }
          });

      button = (Button) view.findViewById(R.id.echo_client_button);
      button.setOnClickListener(
          new View.OnClickListener() {
            public void onClick(View v) {
              Intent intent = new Intent(activity, EchoClientActivity.class);
              startActivityForResult(intent, EchoClientActivity.ECHO_CLIENT_ACTIVITY_REQUEST);
            }
          });

      button = (Button) view.findViewById(R.id.on_off_cluster_button);
      button.setOnClickListener(
          new View.OnClickListener() {
            public void onClick(View v) {
              Intent intent = new Intent(activity, OnOffActivity.class);
              startActivityForResult(intent, OnOffActivity.ON_OFF_ACTIVITY_REQUEST);
            }
          });
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    ConnectionStatusFragment.updateStatus(this);
  }
}
