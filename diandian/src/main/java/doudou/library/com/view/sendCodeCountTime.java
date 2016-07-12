package doudou.library.com.view;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * 发送验证码的计时器
 * @author liubo
 *         Create at 16/7/11 13:44.
 */
public class sendCodeCountTime extends CountDownTimer {
    private Button sendCode;
    public sendCodeCountTime(Button button,long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.sendCode = button;
    }
    public void onTick(long millisUntilFinished) {
        sendCode.setClickable(false);
        sendCode.setText(millisUntilFinished/1000+"秒后重发");
    }
    public void onFinish() {
        sendCode.setText("重新发送");
        sendCode.setClickable(true);
    }
}

