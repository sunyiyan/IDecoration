package com.haipeng.decoration.listener;

/**
 * Created by Administrator on 2017/8/12.
 */

public interface OnButtonsSwitchListener {
    /**
     * ButtonsSwitchUtils的接口
     * 这样增加了，ButtonsSwitch的内聚性
     * 好处：1.代码整齐简洁（逻辑整齐）2.方便问题归类排查 3.当做Util方便重复使用代码
     * */

    void OnClickOne();
    void OnClickTwo();
    void OnClickThree();
    void OnClickFour();
    void OnClickFive();
}
