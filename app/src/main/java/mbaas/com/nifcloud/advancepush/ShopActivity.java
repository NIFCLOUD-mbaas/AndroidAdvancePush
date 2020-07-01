package mbaas.com.nifcloud.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nifcloud.mbaas.core.DoneCallback;
import com.nifcloud.mbaas.core.FetchFileCallback;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBFile;
import com.nifcloud.mbaas.core.NCMBInstallation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class ShopActivity extends AppCompatActivity {

    private static final String TAG = "ShopActivity";
    private static final int REQUEST_RESULT  = 0;

    TextView _shop_name;
    ImageView _shop_image;
    ImageView _favorite_image;
    Button _btn_favorite;
    private Common common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        common = (Common) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        _shop_name = (TextView) findViewById(R.id.txtShop);
        _shop_image = (ImageView) findViewById(R.id.imgShop);
        _favorite_image = (ImageView) findViewById(R.id.imgFavorite);
        _btn_favorite = (Button) findViewById(R.id.btnFavorite);

        //intentから前のActivityからゲット
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String objectId = extras.getString("objectId");
            final String name = extras.getString("name");
            final String shop_image = extras.getString("shop_image");

            _shop_name.setText(name);

            //**************** 【mBaaS/File②: ショップ詳細画像を取得】***************



            Log.d("test", common.currentUser.getList("favorite").toString());
            //Show favorite information
            if (common.currentUser.getList("favorite").contains(objectId)) {
                _favorite_image.setImageResource(R.drawable.favorite);
                _btn_favorite.setEnabled(false);
            }else {
                _favorite_image.setImageResource(R.drawable.nofavorite);
                _btn_favorite.setEnabled(true);
            }

            //Btn favorite update の処理を実装
            _btn_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    doFavoriteRegister(objectId, name, shop_image);
                }
            });

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.onHomeShopFab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the Info activity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT);
                }
            });
        }

    }


    protected void doFavoriteRegister(final String objId, final String name, final String shop_image) {
        //**************** 【mBaaS/User⑤: 会員情報更新】***************


        //****************【mBaaS：プッシュ通知⑤】installationにユーザー情報を紐づける***************


    }

}
