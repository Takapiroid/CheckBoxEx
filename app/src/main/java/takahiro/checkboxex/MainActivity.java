package takahiro.checkboxex;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String BR = System.getProperty("line.separator");
    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        // チェックボックス生成
        checkBox = new CheckBox(this);
        checkBox.setText("チェックボックス");
        checkBox.setTextColor(Color.rgb(0, 0, 0));
        checkBox.setChecked(true);
        checkBox.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox);

        // ラジオボタン0の生成
        RadioButton radio0 = new RadioButton(this);
        radio0.setId(0);
        radio0.setText("ラジオボタン0");
        radio0.setTextColor(Color.rgb(0, 0, 0));

        // ラジオボタン1の生成
        RadioButton radio1 = new RadioButton(this);
        radio1.setId(1);
        radio1.setText("ラジオボタン1");
        radio1.setTextColor(Color.rgb(0, 0, 0));

        // ラジオグループの生成
        radioGroup = new RadioGroup(this);
        radioGroup.addView(radio0);
        radioGroup.addView(radio1);
        radioGroup.check(0);
        radioGroup.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(radioGroup);

        // スピナ―の設定
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        String[] strs = {"赤", "青", "黄"};
        for(int i = 0; i < strs.length; i++) {
            adapter.add(strs[i]);
        }
        spinner = new Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(spinner);

        // ボタンの生成
        button = new Button(this);
        button.setText("結果表示");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // チェックボックスとラジオボタンをスピナ―の状態取得
        toast("チェックボックス>" + checkBox.isChecked() + BR + "ラジオボタン>"
                + radioGroup.getCheckedRadioButtonId() + BR + "スピナ―>" + spinner.getSelectedItem());
    }

    private void toast(String text) {
        if(text != null) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
