# CanvasCustomView
![alt tag](https://github.com/yenspkt/CanvasCustomView/blob/6fbf762dbbde93ae91d3bd72f75861d0961efa36/Screenshot_20160923-135239%5B1%5D.png)

# Usage

You can change color of underline (before - after - editing text) in EnterTextView.java:

This code:
+ before: colorPrimaryDark
+ after: colorPrimary
+ editing: colorAccent

You can define number of underline by android:maxLength 

```javascript
<com.example.admin.canvascustomview.EnterTextView
        android:layout_width="match_parent"
        android:layout_height="72dp"
        android:layout_gravity="center"
        android:layout_marginBottom="24dp"
        android:layout_marginLeft="72dp"
        android:layout_marginRight="72dp"
        android:layout_marginTop="20dp"
        android:maxLength="4"
        android:textSize="36sp"/>
```
