package com.example.moveintent;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class Activity5 extends AppCompatActivity implements View.OnClickListener {
    private Button btnBack;

    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }


    public void increment(View view){
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity-1;
        display(quantity);
    }


    public void SubmitOrder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("Activity5","Nama:"+name);

        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
        Log.v("Activity5","Tambahkan biaya ongkir? "+haswhippedcream);

        int price=calculateprice(haswhippedcream);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,haswhippedcream);


        displayMessage(pricemessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                "just java order for" + name);
        intent.putExtra(Intent.EXTRA_TEXT, pricemessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    private int calculateprice(boolean addwhipedcream){//jumlah pesanan * harga
        int harga=1;

        if(addwhipedcream){
            harga=harga+2;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addWhippedCream) {//hasil pemesanan
        String pricemessage=" Nama ="+name;
        pricemessage+="\n Tambahkan biaya ongkir? "+addWhippedCream;
        pricemessage+="\n Jumlah="+quantity;
        pricemessage+="\n Total= $ "+price;
        pricemessage+="\n Terima Kasih :)";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }


}

