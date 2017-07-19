# BottomPopupWindow
仿网易底部弹出框。
=========
#### 1.使用```BottomSheetDialog```或```PopupWindow```，它们的阴影背景是全覆盖的，这就造成除菜单内容View外的其他部分都是阴影；
#### 2.```BottomPopupWindowView```继承```LinearLayout```，而```layout_bottom_popup.xml```是整个```BottomPopupWindowView```的骨架，然后在```BottomPopupWindowView```初始化时通过```addView()```加载整个骨架内容布局;
#### 3.在```onDraw()```里只需加载一次```baseView```便可，重复加载导致报错，这样便初始化成功。刚开始只会加载```baseView```的界面，相当于严选最下面的立即购买、加入购物车部分；
