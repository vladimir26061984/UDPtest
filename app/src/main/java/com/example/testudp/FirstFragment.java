package com.example.testudp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_first, container, false);
        v.findViewById(R.id.button_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    MainActivity aaa =  (MainActivity)(view.getContext());
                    EditText IP2 =  (EditText)aaa.findViewById(R.id.editText_IP);
                    Source.IP2 = IP2.getText().toString();
                    EditText port1 =  (EditText)aaa.findViewById(R.id.editText_portA);
                    Source.port1 = port1.getText().toString();
                    EditText port2 =  (EditText)aaa.findViewById(R.id.editText_portB);
                    Source.port2 = port2.getText().toString();
                }
                catch (Exception exc)
                {
                    Log.e("FirstFragment", "onClick", exc);

                }

            }
        });

        v.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    MainActivity aaa =  (MainActivity)(view.getContext());
                    EditText edt_send_message =  (EditText)aaa.findViewById(R.id.edt_send_message);
                    Source.LastMessage = edt_send_message.getText().toString();
                }
                catch (Exception exc)
                {
                    Log.e("FirstFragment", "onClick", exc);

                }

            }
        });

        v.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    MainActivity aaa =  (MainActivity)(view.getContext());
                    //отправить сообщение
                    aaa.sendMessage(aaa.mEditTextSendMessage.getText().toString());
                    aaa.mEditTextSendMessage.setText("");
                }
                catch (Exception exc)
                {
                    Log.e("FirstFragment", "onClick", exc);

                }

            }
        });

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






        TextView label =  view.findViewById(R.id.textview_first);
        try
        {
            MainActivity aaa =  (MainActivity)(view.getContext());
            String ip = aaa.getDeviceIpAddress();
            Source.IP1 = ip;
            label.setText(ip);
            aaa.mTextViewReplyFromServer = aaa.findViewById(R.id.tv_reply_from_server);
            aaa.mEditTextSendMessage = aaa.findViewById(R.id.edt_send_message);
        }
        catch (Exception exc)
        {
            Log.e("FirstFragment", "setText", exc);

        }
    }


}
